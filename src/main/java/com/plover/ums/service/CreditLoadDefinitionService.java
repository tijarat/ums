package com.plover.ums.service;

import com.plover.ums.dto.CreditLoadDefinitionDTO;
import com.plover.ums.entity.CreditLoadDefinition;
import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.CreditLoadDefinitionRepo;
import com.plover.ums.repo.FacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CreditLoadDefinitionService {

    private final CreditLoadDefinitionRepo repository;
    private final FacultyRepository facultyRepository;

    public CreditLoadDefinitionService(CreditLoadDefinitionRepo repository, FacultyRepository facultyRepository) {
        this.repository = repository;
        this.facultyRepository = facultyRepository;
    }

    public List<CreditLoadDefinitionDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CreditLoadDefinitionDTO save(CreditLoadDefinitionDTO dto) {
        CreditLoadDefinition entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private CreditLoadDefinitionDTO convertToDTO(CreditLoadDefinition entity) {
        return CreditLoadDefinitionDTO.builder()
                .id(entity.getId())
                .creditHours(entity.getCreditHours())
                .classLimit(entity.getClassLimit())
                .facultyId(entity.getFaculty() != null ? entity.getFaculty().getFacultyId() : null)
                .build();
    }

    private CreditLoadDefinition convertToEntity(CreditLoadDefinitionDTO dto) {
        CreditLoadDefinition entity = new CreditLoadDefinition();
        entity.setId(dto.getId());
        entity.setCreditHours(dto.getCreditHours());
        entity.setClassLimit(dto.getClassLimit());

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found"));
            entity.setFaculty(faculty);
        }
        return entity;
    }
}