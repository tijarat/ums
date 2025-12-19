package com.plover.ums.service;

import com.plover.ums.dto.EnvVariableDTO;
import com.plover.ums.entity.EnvVariable;
import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.EnvVariableRepo;
import com.plover.ums.repo.FacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnvVariableService {

    private final EnvVariableRepo repository;
    private final FacultyRepository facultyRepository;

    public EnvVariableService(EnvVariableRepo repository, FacultyRepository facultyRepository) {
        this.repository = repository;
        this.facultyRepository = facultyRepository;
    }

    public List<EnvVariableDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EnvVariableDTO save(EnvVariableDTO dto) {
        EnvVariable entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private EnvVariableDTO convertToDTO(EnvVariable entity) {
        return EnvVariableDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .value(entity.getValue())
                .description(entity.getDescription())
                .type(entity.getType())
                .facultyId(entity.getFaculty() != null ? entity.getFaculty().getFacultyId() : null)
                .build();
    }

    private EnvVariable convertToEntity(EnvVariableDTO dto) {
        EnvVariable entity = new EnvVariable();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setValue(dto.getValue());
        entity.setDescription(dto.getDescription());
        entity.setType(dto.getType());

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found"));
            entity.setFaculty(faculty);
        }
        return entity;
    }
}