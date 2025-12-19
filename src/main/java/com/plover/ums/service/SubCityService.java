package com.plover.ums.service;

import com.plover.ums.dto.SubCityDTO;
import com.plover.ums.entity.SubCity;
import com.plover.ums.repo.CityRepository;
import com.plover.ums.repo.SubCityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCityService {

    private final SubCityRepository subCityRepo;
    private final CityRepository cityRepo;

    public SubCityService(SubCityRepository subCityRepo, CityRepository cityRepo) {
        this.subCityRepo = subCityRepo;
        this.cityRepo = cityRepo;
    }

    public List<SubCityDTO> getAll() {
        return subCityRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public SubCityDTO getById(Long id) {
        return subCityRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public SubCityDTO create(SubCityDTO dto) {
        SubCity subCity = new SubCity();
        subCity.setName(dto.getName());
        subCity.setCode(dto.getCode());

        cityRepo.findById(dto.getCityId()).ifPresent(subCity::setCity);

        return toDTO(subCityRepo.save(subCity));
    }

    public SubCityDTO update(Long id, SubCityDTO dto) {
        return subCityRepo.findById(id).map(subCity -> {
            subCity.setName(dto.getName());
            subCity.setCode(dto.getCode());
            cityRepo.findById(dto.getCityId()).ifPresent(subCity::setCity);
            return toDTO(subCityRepo.save(subCity));
        }).orElse(null);
    }

    public void delete(Long id) {
        subCityRepo.deleteById(id);
    }

    private SubCityDTO toDTO(SubCity subCity) {
        SubCityDTO dto = new SubCityDTO();
        dto.setId(subCity.getId());
        dto.setName(subCity.getName());
        dto.setCode(subCity.getCode());
        dto.setCityId(subCity.getCity() != null ? subCity.getCity().getId() : null);
        return dto;
    }
}
