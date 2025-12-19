package com.plover.ums.service;

import com.plover.ums.dto.RegionDTO;
import com.plover.ums.entity.Region;
import com.plover.ums.repo.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService {

    private final RegionRepository regionRepo;

    public RegionService(RegionRepository regionRepo) {
        this.regionRepo = regionRepo;
    }

    public List<RegionDTO> getAll() {
        return regionRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public RegionDTO getById(Long id) {
        return regionRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public RegionDTO create(RegionDTO dto) {
        Region region = new Region();
        region.setRegionName(dto.getRegionName());
        region.setRegionDesc(dto.getRegionDesc()); 
        return toDTO(regionRepo.save(region));
    }

    public RegionDTO update(Long id, RegionDTO dto) {
        return regionRepo.findById(id).map(region -> {
            region.setRegionName(dto.getRegionName());
            region.setRegionDesc(dto.getRegionDesc());
            return toDTO(regionRepo.save(region));
        }).orElse(null);
    }

    public void delete(Long id) {
        regionRepo.deleteById(id);
    }

    private RegionDTO toDTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setRegionId(region.getRegionId());
        dto.setRegionName(region.getRegionName());
        dto.setRegionDesc(region.getRegionDesc());
        return dto;
    }
}
