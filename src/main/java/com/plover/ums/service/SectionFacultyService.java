package com.plover.ums.service;

import com.plover.ums.dto.SectionFacultyDTO;
import com.plover.ums.entity.SectionFaculty;
import com.plover.ums.entity.Section;
import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.SectionFacultyRepo;
import com.plover.ums.repo.SectionRepository;
import com.plover.ums.repo.FacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SectionFacultyService {

    private final SectionFacultyRepo repository;
    private final SectionRepository sectionRepository;
    private final FacultyRepository facultyRepository;

    public SectionFacultyService(SectionFacultyRepo repository, 
                                SectionRepository sectionRepository, 
                                FacultyRepository facultyRepository) {
        this.repository = repository;
        this.sectionRepository = sectionRepository;
        this.facultyRepository = facultyRepository;
    }

    public List<SectionFacultyDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SectionFacultyDTO save(SectionFacultyDTO dto) {
        Section section = sectionRepository.findById(dto.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section not found"));
        
        Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        SectionFaculty entity = SectionFaculty.builder()
                .sectionId(dto.getSectionId())
                .section(section)
                .faculty(faculty)
                .build();

        return convertToDTO(repository.save(entity));
    }

    private SectionFacultyDTO convertToDTO(SectionFaculty entity) {
        return SectionFacultyDTO.builder()
                .sectionId(entity.getSectionId())
                .sectionName(entity.getSection() != null ? entity.getSection().getSectionText(): null)
                .facultyId(entity.getFaculty() != null ? entity.getFaculty().getFacultyId() : null)
                .facultyName(entity.getFaculty() != null ? entity.getFaculty().getFacultyName() : null)
                .build();
    }
}