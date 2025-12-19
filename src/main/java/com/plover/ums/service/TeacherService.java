package com.plover.ums.service;

import com.plover.ums.dto.TeacherDTO;
import com.plover.ums.entity.Designation;
import com.plover.ums.entity.Teacher;
import com.plover.ums.repo.TeacherRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository repo;
    private final EntityManager em;

    public TeacherService(TeacherRepository repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public TeacherDTO save(TeacherDTO dto) {
        Teacher teacher = new Teacher();
        
        // Manual Mapping from DTO to Entity
        teacher.setTeacherName(dto.getTeacherName());
        teacher.setTeacherAbbr(dto.getTeacherAbbr());
        teacher.setAddress(dto.getAddress());
        teacher.setPhoneNumber(dto.getPhoneNumber());
        teacher.setCellNumber(dto.getCellNumber());
        teacher.setOfficeAddress(dto.getOfficeAddress());
        teacher.setOfficePhone(dto.getOfficePhone());
        teacher.setEmail(dto.getEmail());
        teacher.setStatus(dto.getStatus());
        teacher.setJoiningDate(dto.getJoiningDate());
        teacher.setTypeIndicator(dto.getTypeIndicator());
        teacher.setTeacherRate(dto.getTeacherRate());
        teacher.setOfficePhoneExt(dto.getOfficePhoneExt());
        teacher.setPersonalWebUrl(dto.getPersonalWebUrl());
        teacher.setFolderName(dto.getFolderName());
        teacher.setNic(dto.getNic());

        // Handling Foreign Key for Designation
        if (dto.getDesignationId() != null) {
            teacher.setDesignation(em.getReference(Designation.class, dto.getDesignationId()));
        }

        Teacher savedTeacher = repo.save(teacher);
        dto.setTeacherId(savedTeacher.getTeacherId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<TeacherDTO> findAll() {
        return repo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TeacherDTO mapToDTO(Teacher t) {
        TeacherDTO dto = new TeacherDTO();
        dto.setTeacherId(t.getTeacherId());
        dto.setTeacherName(t.getTeacherName());
        dto.setTeacherAbbr(t.getTeacherAbbr());
        dto.setNic(t.getNic());
        dto.setStatus(t.getStatus());
        if (t.getDesignation() != null) {
            dto.setDesignationId(t.getDesignation().getDesignationId());
        }
        return dto;
    }
}