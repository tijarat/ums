package com.plover.ums.service;

import com.plover.ums.dto.NoticeBoardDTO;
import com.plover.ums.entity.NoticeBoard;
import com.plover.ums.entity.Designation;
import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.NoticeBoardRepo;
import com.plover.ums.repo.DesignationRepository;
import com.plover.ums.repo.FacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoticeBoardService {

    private final NoticeBoardRepo repository;
    private final DesignationRepository designationRepository;
    private final FacultyRepository facultyRepository;

    public NoticeBoardService(NoticeBoardRepo repository, 
                              DesignationRepository designationRepository, 
                              FacultyRepository facultyRepository) {
        this.repository = repository;
        this.designationRepository = designationRepository;
        this.facultyRepository = facultyRepository;
    }

    public List<NoticeBoardDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public NoticeBoardDTO save(NoticeBoardDTO dto) {
        NoticeBoard entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private NoticeBoardDTO convertToDTO(NoticeBoard entity) {
        return NoticeBoardDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .fromDate(entity.getFromDate())
                .toDate(entity.getToDate())
                .fromName(entity.getFromName())
                .designationId(entity.getDesignation().getDesignationId())
                .facultyId(entity.getFaculty() != null ? entity.getFaculty().getFacultyId() : null)
                .build();
    }

    private NoticeBoard convertToEntity(NoticeBoardDTO dto) {
        NoticeBoard entity = new NoticeBoard();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setFromDate(dto.getFromDate());
        entity.setToDate(dto.getToDate());
        entity.setFromName(dto.getFromName());

        Designation designation = designationRepository.findById(dto.getDesignationId())
                .orElseThrow(() -> new RuntimeException("Designation not found"));
        entity.setDesignation(designation);

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found"));
            entity.setFaculty(faculty);
        }
        return entity;
    }
}