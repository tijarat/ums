package com.plover.ums.service;

import com.plover.ums.dto.UserTermAllocationDTO;
import com.plover.ums.entity.*;
import com.plover.ums.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserTermAllocationService {

    private final UserTermAllocationRepo repository;
    private final UserRepository userRepository;
    private final TermRepository termRepository;
    private final FacultyRepository facultyRepository;

    public UserTermAllocationService(UserTermAllocationRepo repository, UserRepository userRepository, 
                                     TermRepository termRepository, FacultyRepository facultyRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.termRepository = termRepository;
        this.facultyRepository = facultyRepository;
    }

    public UserTermAllocationDTO save(UserTermAllocationDTO dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Term term = termRepository.findById(dto.getTermCode())
                .orElseThrow(() -> new RuntimeException("Term not found"));
        
        UserTermAllocationId id = new UserTermAllocationId(dto.getUserId(), dto.getTermCode());
        
        UserTermAllocation entity = UserTermAllocation.builder()
                .id(id)
                .user(user)
                .term(term)
                .fromDate(dto.getFromDate())
                .toDate(dto.getToDate())
                .disallowIndicator(dto.getDisallowIndicator() != null ? dto.getDisallowIndicator() : "0")
                .build();

        if (dto.getFacultyId() != null) {
            entity.setFaculty(facultyRepository.findById(dto.getFacultyId()).orElse(null));
        }

        return convertToDTO(repository.save(entity));
    }

    private UserTermAllocationDTO convertToDTO(UserTermAllocation entity) {
        return UserTermAllocationDTO.builder()
                .userId(entity.getId().getUserId())
                .termCode(entity.getId().getTermCode())
                .fromDate(entity.getFromDate())
                .toDate(entity.getToDate())
                .disallowIndicator(entity.getDisallowIndicator())
                .facultyId(entity.getFaculty() != null ? entity.getFaculty().getFacultyId() : null)
                .build();
    }
}