package com.plover.ums.service;

import com.plover.ums.dto.ModuleDTO;
import com.plover.ums.entity.ModuleEntity;
import com.plover.ums.repo.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepo repository;

    public List<ModuleDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ModuleDTO save(ModuleDTO dto) {
        ModuleEntity entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private ModuleDTO convertToDTO(ModuleEntity entity) {
        ModuleDTO dto = new ModuleDTO();
        dto.setModuleId(entity.getModuleId());
        dto.setModuleName(entity.getModuleName());
        return dto;
    }

    private ModuleEntity convertToEntity(ModuleDTO dto) {
        ModuleEntity entity = new ModuleEntity();
        entity.setModuleId(dto.getModuleId());
        entity.setModuleName(dto.getModuleName());
        return entity;
    }
}