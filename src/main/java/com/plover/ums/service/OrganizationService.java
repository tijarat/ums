package com.plover.ums.service;

import com.plover.ums.dto.OrganizationDTO;
import com.plover.ums.entity.Organization;
import com.plover.ums.entity.SubCity;
import com.plover.ums.repo.OrganizationRepository;
import com.plover.ums.repo.SubCityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    private final OrganizationRepository orgRepo;
    private final SubCityRepository subCityRepo;

    public OrganizationService(OrganizationRepository orgRepo, SubCityRepository subCityRepo) {
        this.orgRepo = orgRepo;
        this.subCityRepo = subCityRepo;
    }

    public List<OrganizationDTO> getAll() {
        return orgRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public OrganizationDTO getById(Long id) {
        return orgRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public OrganizationDTO create(OrganizationDTO dto) {
        Organization org = new Organization();
        org.setName(dto.getName());

        Optional<SubCity> subCity = subCityRepo.findById(dto.getSubCityId());
        subCity.ifPresent(org::setSubCity);

        return toDTO(orgRepo.save(org));
    }

    public OrganizationDTO update(Long id, OrganizationDTO dto) {
        return orgRepo.findById(id).map(org -> {
            org.setName(dto.getName());
            subCityRepo.findById(dto.getSubCityId()).ifPresent(org::setSubCity);
            return toDTO(orgRepo.save(org));
        }).orElse(null);
    }

    public void delete(Long id) {
        orgRepo.deleteById(id);
    }

    private OrganizationDTO toDTO(Organization org) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setId(org.getId());
        dto.setName(org.getName());
        dto.setSubCityId(org.getSubCity() != null ? org.getSubCity().getId() : null);
        return dto;
    }
}
