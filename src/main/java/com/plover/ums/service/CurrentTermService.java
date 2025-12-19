package com.plover.ums.service;

import com.plover.ums.dto.CurrentTermDTO;
import com.plover.ums.entity.CurrentTerm;
import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.CurrentTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrentTermService {

    @Autowired
    private CurrentTermRepository repository;

    public List<CurrentTermDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CurrentTermDTO save(CurrentTermDTO dto) {
        CurrentTerm entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private CurrentTermDTO convertToDTO(CurrentTerm entity) {
        CurrentTermDTO dto = new CurrentTermDTO();
        dto.setTermCode(entity.getTermCode());
        dto.setFacultyAbbrev(entity.getFacultyAbbrev());
        if (entity.getFaculty() != null) dto.setFacultyId(entity.getFaculty().getFacultyId());
        return dto;
    }

    private CurrentTerm convertToEntity(CurrentTermDTO dto) {
        CurrentTerm entity = new CurrentTerm();
        entity.setTermCode(dto.getTermCode());
        entity.setFacultyAbbrev(dto.getFacultyAbbrev());
        // Map Faculty Parent Reference
        if (dto.getFacultyId() != null) {
            Faculty faculty = new Faculty();
            faculty.setFacultyId(dto.getFacultyId());
            entity.setFaculty(faculty);
        }
        return entity;
    }
}