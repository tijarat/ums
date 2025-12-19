package com.plover.ums.service;

import com.plover.ums.dto.SpecialRightsDTO;
import com.plover.ums.entity.SpecialRights;
import com.plover.ums.repo.SpecialRightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SpecialRightsService {

    private final SpecialRightsRepo repository;

    public SpecialRightsService(SpecialRightsRepo repository) {
        this.repository = repository;
    }

    public List<SpecialRightsDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SpecialRightsDTO save(SpecialRightsDTO dto) {
        SpecialRights entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private SpecialRightsDTO convertToDTO(SpecialRights entity) {
        return SpecialRightsDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    private SpecialRights convertToEntity(SpecialRightsDTO dto) {
        return SpecialRights.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}