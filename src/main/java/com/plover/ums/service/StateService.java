package com.plover.ums.service;

import com.plover.ums.dto.StateDTO;
import com.plover.ums.entity.Country;
import com.plover.ums.entity.State;
import com.plover.ums.repo.CountryRepository;
import com.plover.ums.repo.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateService {

    private final StateRepository stateRepo;
    private final CountryRepository countryRepo;

    public StateService(StateRepository stateRepo, CountryRepository countryRepo) {
        this.stateRepo = stateRepo;
        this.countryRepo = countryRepo;
    }

    public List<StateDTO> getAll() {
        return stateRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public StateDTO getById(Long id) {
        return stateRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public StateDTO create(StateDTO dto) {
        State state = new State();
        state.setName(dto.getName());
        state.setDescription(dto.getDescription());
        countryRepo.findById(dto.getCountryId()).ifPresent(state::setCountry);
        return toDTO(stateRepo.save(state));
    }

    public StateDTO update(Long id, StateDTO dto) {
        return stateRepo.findById(id).map(state -> {
            state.setName(dto.getName());
            state.setDescription(dto.getDescription());
            countryRepo.findById(dto.getCountryId()).ifPresent(state::setCountry);
            return toDTO(stateRepo.save(state));
        }).orElse(null);
    }

    public void delete(Long id) {
        stateRepo.deleteById(id);
    }

    private StateDTO toDTO(State state) {
        StateDTO dto = new StateDTO();
        dto.setId(state.getId());
        dto.setName(state.getName());
        dto.setDescription(state.getDescription());
        dto.setCountryId(state.getCountry() != null ? state.getCountry().getId() : null);
        return dto;
    }
}
