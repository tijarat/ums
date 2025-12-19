package com.plover.ums.service;

import com.plover.ums.dto.AbsentLimitDTO;
import com.plover.ums.entity.AbsentLimit;
import com.plover.ums.repo.AbsentLimitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbsentLimitService{

    @Autowired
    private AbsentLimitRepo repo;

    public AbsentLimitDTO save(AbsentLimitDTO dto) {
        AbsentLimit entity = mapToEntity(dto);
        return mapToDTO(repo.save(entity));
    }

    public AbsentLimitDTO update(AbsentLimitDTO dto) {
        AbsentLimit entity = mapToEntity(dto);
        return mapToDTO(repo.save(entity));
    }

    public AbsentLimitDTO findById(Long id) {
        return repo.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    public List<AbsentLimitDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AbsentLimitDTO> findByFaculty(Long facultyId) {
        return repo.findByFacultyId(facultyId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private AbsentLimit mapToEntity(AbsentLimitDTO dto) {
        AbsentLimit e = new AbsentLimit();
        e.setAbsentLimitId(dto.getAbsentLimitId());
        e.setCreditHrs(dto.getCreditHrs());
        e.setAbsentLimit(dto.getAbsentLimit());
        e.setFacultyId(dto.getFacultyId());
        e.setAbsentLimitSports(dto.getAbsentLimitSports());
        return e;
    }

    private AbsentLimitDTO mapToDTO(AbsentLimit e) {
        AbsentLimitDTO dto = new AbsentLimitDTO();
        dto.setAbsentLimitId(e.getAbsentLimitId());
        dto.setCreditHrs(e.getCreditHrs());
        dto.setAbsentLimit(e.getAbsentLimit());
        dto.setFacultyId(e.getFacultyId());
        dto.setAbsentLimitSports(e.getAbsentLimitSports());
        return dto;
    }
}
