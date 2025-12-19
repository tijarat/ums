package com.plover.ums.service;

import com.plover.ums.dto.CampusDTO;
import com.plover.ums.entity.Campus;
import com.plover.ums.entity.SubCity;
import com.plover.ums.entity.University;
import com.plover.ums.repo.CampusRepository;
import com.plover.ums.repo.SubCityRepository;
import com.plover.ums.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampusService {

    private final CampusRepository campusRepo;
    private final SubCityRepository subCityRepo;
    private final UniversityRepository universityRepo;

    public CampusService(CampusRepository campusRepo,
                         SubCityRepository subCityRepo,
                         UniversityRepository universityRepo) {
        this.campusRepo = campusRepo;
        this.subCityRepo = subCityRepo;
        this.universityRepo = universityRepo;
    }

    public List<CampusDTO> getAll() {
        return campusRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CampusDTO getById(Long id) {
        return campusRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public CampusDTO create(CampusDTO dto) {
        Campus campus = new Campus();
        campus.setName(dto.getName());
        campus.setPrefix(dto.getPrefix());
        campus.setCode(dto.getCode());

        subCityRepo.findById(dto.getSubCityId()).ifPresent(campus::setSubCity);
        universityRepo.findById(dto.getUniversityId()).ifPresent(campus::setUniversity);

        return toDTO(campusRepo.save(campus));
    }

    public CampusDTO update(Long id, CampusDTO dto) {
        return campusRepo.findById(id).map(campus -> {
            campus.setName(dto.getName());
            campus.setPrefix(dto.getPrefix());
            campus.setCode(dto.getCode());
            subCityRepo.findById(dto.getSubCityId()).ifPresent(campus::setSubCity);
            universityRepo.findById(dto.getUniversityId()).ifPresent(campus::setUniversity);
            return toDTO(campusRepo.save(campus));
        }).orElse(null);
    }

    public void delete(Long id) {
        campusRepo.deleteById(id);
    }

    private CampusDTO toDTO(Campus campus) {
        CampusDTO dto = new CampusDTO();
        dto.setId(campus.getId());
        dto.setName(campus.getName());
        dto.setPrefix(campus.getPrefix());
        dto.setCode(campus.getCode());
        dto.setSubCityId(campus.getSubCity() != null ? campus.getSubCity().getId() : null);
        dto.setUniversityId(campus.getUniversity() != null ? campus.getUniversity().getId() : null);
        return dto;
    }
}
