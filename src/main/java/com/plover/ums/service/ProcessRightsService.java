package com.plover.ums.service;

import com.plover.ums.dto.ProcessRightsDTO;
import com.plover.ums.entity.ProcessRights;
import com.plover.ums.entity.UserEntity;
import com.plover.ums.entity.SpecialRights;
import com.plover.ums.repo.ProcessRightsRepo;
import com.plover.ums.repo.UserRepository;
import com.plover.ums.repo.SpecialRightsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcessRightsService {

    private final ProcessRightsRepo repository;
    private final UserRepository userRepository;
    private final SpecialRightsRepo rightsRepository;

    public ProcessRightsService(ProcessRightsRepo repository, 
                               UserRepository userRepository, 
                               SpecialRightsRepo rightsRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.rightsRepository = rightsRepository;
    }

    public ProcessRightsDTO assignRight(ProcessRightsDTO dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
            
        SpecialRights right = rightsRepository.findById(dto.getSpecialRightsId())
            .orElseThrow(() -> new RuntimeException("Special Right not found"));

        ProcessRights entity = ProcessRights.builder()
                .user(user)
                .specialRights(right)
                .build();

        return convertToDTO(repository.save(entity));
    }

    public List<ProcessRightsDTO> getRightsByUser(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProcessRightsDTO convertToDTO(ProcessRights entity) {
        return ProcessRightsDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .userName(entity.getUser().getUsername()) // Assumes getUserName() exists
                .specialRightsId(entity.getSpecialRights().getId())
                .rightName(entity.getSpecialRights().getName())
                .build();
    }
}