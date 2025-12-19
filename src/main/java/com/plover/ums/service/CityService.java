package com.plover.ums.service;

import com.plover.ums.dto.CityDTO;
import com.plover.ums.entity.City;
import com.plover.ums.entity.State;
import com.plover.ums.repo.CityRepository;
import com.plover.ums.repo.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepo;
    private final StateRepository stateRepo;

    public CityService(CityRepository cityRepo, StateRepository stateRepo) {
        this.cityRepo = cityRepo;
        this.stateRepo = stateRepo;
    }

    // Get all cities
    public List<CityDTO> getAll() {
        return cityRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Get city by ID
    public CityDTO getById(Long id) {
        return cityRepo.findById(id).map(this::toDTO).orElse(null);
    }

    // Create new city
    public CityDTO create(CityDTO dto) {
        City city = new City();
        city.setName(dto.getName());
        city.setCode(dto.getCode());
        city.setPhonePrefix(dto.getPhonePrefix());

        Optional<State> state = stateRepo.findById(dto.getStateId());
        state.ifPresent(city::setState);

        return toDTO(cityRepo.save(city));
    }

    // Update existing city
    public CityDTO update(Long id, CityDTO dto) {
        return cityRepo.findById(id).map(city -> {
            city.setName(dto.getName());
            city.setCode(dto.getCode());
            city.setPhonePrefix(dto.getPhonePrefix());
            stateRepo.findById(dto.getStateId()).ifPresent(city::setState);
            return toDTO(cityRepo.save(city));
        }).orElse(null);
    }

    // Delete city
    public void delete(Long id) {
        cityRepo.deleteById(id);
    }

    // Convert entity to DTO
    private CityDTO toDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setCode(city.getCode());
        dto.setPhonePrefix(city.getPhonePrefix());
        dto.setStateId(city.getState() != null ? city.getState().getId() : null);
        return dto;
    }
}
