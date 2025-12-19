package com.plover.ums.service;

import com.plover.ums.dto.DesignationDTO;
import com.plover.ums.entity.Designation;
import com.plover.ums.repo.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository repository;

    public List<DesignationDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DesignationDTO save(DesignationDTO dto) {
        Designation entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private DesignationDTO convertToDTO(Designation entity) {
        DesignationDTO dto = new DesignationDTO();
        dto.setDesignationId(entity.getDesignationId());
        dto.setShortDesignation(entity.getShortDesignation());
        dto.setLongDesignation(entity.getLongDesignation());
        return dto;
    }

    private Designation convertToEntity(DesignationDTO dto) {
        Designation entity = new Designation();
        entity.setDesignationId(dto.getDesignationId());
        entity.setShortDesignation(dto.getShortDesignation());
        entity.setLongDesignation(dto.getLongDesignation());
        return entity;
    }
}