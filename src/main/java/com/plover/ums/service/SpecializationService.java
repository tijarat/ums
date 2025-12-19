package com.plover.ums.service;

import com.plover.ums.dto.SpecializationDTO;
import com.plover.ums.entity.Specialization;
import com.plover.ums.repo.SpecializationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecializationService {
    private final SpecializationRepo repo;

    public SpecializationService(SpecializationRepo repo) { this.repo = repo; }

    @Transactional
    public SpecializationDTO save(SpecializationDTO dto) {
        Specialization spec = new Specialization();
        spec.setAbbrev(dto.getAbbrev());
        spec.setDescription(dto.getDescription());
        
        Specialization saved = repo.save(spec);
        dto.setSpId(saved.getSpId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<SpecializationDTO> findAll() {
        return repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private SpecializationDTO mapToDto(Specialization s) {
        SpecializationDTO dto = new SpecializationDTO();
        dto.setSpId(s.getSpId());
        dto.setAbbrev(s.getAbbrev());
        dto.setDescription(s.getDescription());
        return dto;
    }
}