package com.plover.ums.service;

import com.plover.ums.dto.ProgramDTO;
import com.plover.ums.entity.Faculty;
import com.plover.ums.entity.Program;
import com.plover.ums.repo.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository repository;

    // --- Added missing findAll method ---
    public List<ProgramDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // --- Added missing findById method ---
    public ProgramDTO findById(Long id) {
        Program entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found with id: " + id));
        return convertToDTO(entity);
    }

    public ProgramDTO save(ProgramDTO dto) {
        Program entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    // --- Added missing delete method ---
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProgramDTO convertToDTO(Program entity) {
        ProgramDTO dto = new ProgramDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        if (entity.getFaculty() != null) dto.setFacultyId(entity.getFaculty().getFacultyId());
        return dto;
    }

    private Program convertToEntity(ProgramDTO dto) {
        Program entity = new Program();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        
        if (dto.getFacultyId() != null) {
            Faculty faculty = new Faculty();
            faculty.setFacultyId(dto.getFacultyId());
            entity.setFaculty(faculty);
        }
        return entity;
    }
}