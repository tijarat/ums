package com.plover.ums.service;

import com.plover.ums.dto.TeacherRteDTO;
import com.plover.ums.entity.Section;
import com.plover.ums.entity.Teacher;
import com.plover.ums.entity.TeacherRte;
import com.plover.ums.repo.TeacherRteRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherRteService {

    private final TeacherRteRepo repo;
    private final EntityManager em;

    public TeacherRteService(TeacherRteRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public TeacherRteDTO save(TeacherRteDTO dto) {
        TeacherRte entity = new TeacherRte();
        entity.setTeacherRate(dto.getTeacherRate());

        // Use getReference for efficient Foreign Key mapping
        if (dto.getSectionId() != null) {
            entity.setSection(em.getReference(Section.class, dto.getSectionId()));
        }
        if (dto.getTeacherId() != null) {
            entity.setTeacher(em.getReference(Teacher.class, dto.getTeacherId()));
        }

        TeacherRte saved = repo.save(entity);
        dto.setTeacherRateId(saved.getTeacherRateId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<TeacherRteDTO> findAll() {
        return repo.findAll().stream().map(entity -> {
            TeacherRteDTO dto = new TeacherRteDTO();
            dto.setTeacherRateId(entity.getTeacherRateId());
            dto.setTeacherRate(entity.getTeacherRate());
            if (entity.getSection() != null) dto.setSectionId(entity.getSection().getSectionId());
            if (entity.getTeacher() != null) dto.setTeacherId(entity.getTeacher().getTeacherId());
            return dto;
        }).collect(Collectors.toList());
    }
}