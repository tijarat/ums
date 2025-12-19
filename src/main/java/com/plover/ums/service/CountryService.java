package com.plover.ums.service;

import com.plover.ums.dto.CountryDTO;
import com.plover.ums.entity.Country;
import com.plover.ums.entity.Region;
import com.plover.ums.repo.CountryRepository;
import com.plover.ums.repo.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepo;
    private final RegionRepository regionRepo;

    public CountryService(CountryRepository countryRepo, RegionRepository regionRepo) {
        this.countryRepo = countryRepo;
        this.regionRepo = regionRepo;
    }

    public List<CountryDTO> getAll() {
        return countryRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CountryDTO getById(Long id) {
        return countryRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public CountryDTO create(CountryDTO dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setCode2(dto.getCode2());
        country.setCode3(dto.getCode3());
        country.setPhonePrefix(dto.getPhonePrefix());

        Optional<Region> region = regionRepo.findById(dto.getRegionId());
        region.ifPresent(country::setRegion);

        return toDTO(countryRepo.save(country));
    }

    public CountryDTO update(Long id, CountryDTO dto) {
        return countryRepo.findById(id).map(country -> {
            country.setName(dto.getName());
            country.setCode2(dto.getCode2());
            country.setCode3(dto.getCode3());
            country.setPhonePrefix(dto.getPhonePrefix());
            regionRepo.findById(dto.getRegionId()).ifPresent(country::setRegion);
            return toDTO(countryRepo.save(country));
        }).orElse(null);
    }

    public void delete(Long id) {
        countryRepo.deleteById(id);
    }

    private CountryDTO toDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setCode2(country.getCode2());
        dto.setCode3(country.getCode3());
        dto.setPhonePrefix(country.getPhonePrefix());
        dto.setRegionId(country.getRegion() != null ? country.getRegion().getRegionId() : null);
        return dto;
    }
}
