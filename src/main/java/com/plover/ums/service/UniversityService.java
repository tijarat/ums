package com.plover.ums.service;

import com.plover.ums.dto.UniversityDTO;
import com.plover.ums.entity.Organization;
import com.plover.ums.entity.SubCity;
import com.plover.ums.entity.University;
import com.plover.ums.repo.OrganizationRepository;
import com.plover.ums.repo.SubCityRepository;
import com.plover.ums.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UniversityService {

    private final UniversityRepository universityRepo;
    private final SubCityRepository subCityRepo;
    private final OrganizationRepository organizationRepo;

    public UniversityService(UniversityRepository universityRepo,
                             SubCityRepository subCityRepo,
                             OrganizationRepository organizationRepo) {
        this.universityRepo = universityRepo;
        this.subCityRepo = subCityRepo;
        this.organizationRepo = organizationRepo;
    }

    public List<UniversityDTO> getAll() {
        return universityRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UniversityDTO getById(Long id) {
        return universityRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public UniversityDTO create(UniversityDTO dto) {
        University uni = new University();
        uni.setName(dto.getName());
        uni.setPrefix(dto.getPrefix());
        uni.setCode(dto.getCode());

        subCityRepo.findById(dto.getSubCityId()).ifPresent(uni::setSubCity);
        organizationRepo.findById(dto.getOrganizationId()).ifPresent(uni::setOrganization);

        return toDTO(universityRepo.save(uni));
    }

    public UniversityDTO update(Long id, UniversityDTO dto) {
        return universityRepo.findById(id).map(uni -> {
            uni.setName(dto.getName());
            uni.setPrefix(dto.getPrefix());
            uni.setCode(dto.getCode());
            subCityRepo.findById(dto.getSubCityId()).ifPresent(uni::setSubCity);
            organizationRepo.findById(dto.getOrganizationId()).ifPresent(uni::setOrganization);
            return toDTO(universityRepo.save(uni));
        }).orElse(null);
    }

    public void delete(Long id) {
        universityRepo.deleteById(id);
    }

    private UniversityDTO toDTO(University uni) {
        UniversityDTO dto = new UniversityDTO();
        dto.setId(uni.getId());
        dto.setName(uni.getName());
        dto.setPrefix(uni.getPrefix());
        dto.setCode(uni.getCode());
        dto.setSubCityId(uni.getSubCity() != null ? uni.getSubCity().getId() : null);
        dto.setOrganizationId(uni.getOrganization() != null ? uni.getOrganization().getId() : null);
        return dto;
    }
}
