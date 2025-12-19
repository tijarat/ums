package com.plover.ums.service;

import com.plover.ums.dto.WebUserFacultyDTO;
import com.plover.ums.entity.*;
import com.plover.ums.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WebUserFacultyService {

    private final WebUserFacultyRepo repository;
    private final UserRepository userRepository;
    private final FacultyRepository facultyRepository;

    public WebUserFacultyService(WebUserFacultyRepo repository, 
                                 UserRepository userRepository, 
                                 FacultyRepository facultyRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.facultyRepository = facultyRepository;
    }

    public List<WebUserFacultyDTO> getFacultiesByUser(String userId) {
        return repository.findByIdUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WebUserFacultyDTO assignFaculty(WebUserFacultyDTO dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        WebUserFacultyId id = new WebUserFacultyId(dto.getUserId(), dto.getFacultyId());
        WebUserFaculty entity = WebUserFaculty.builder()
                .id(id)
                .user(user)
                .faculty(faculty)
                .build();

        return convertToDTO(repository.save(entity));
    }

    private WebUserFacultyDTO convertToDTO(WebUserFaculty entity) {
        return WebUserFacultyDTO.builder()
                .userId(entity.getId().getUserId())
                .facultyId(entity.getId().getFacultyId())
                .facultyName(entity.getFaculty() != null ? entity.getFaculty().getFacultyName() : null)
                .build();
    }
}