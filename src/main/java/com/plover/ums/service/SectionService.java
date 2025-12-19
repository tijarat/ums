package com.plover.ums.service;

import com.plover.ums.dto.SectionDto;
import com.plover.ums.entity.Course;
import com.plover.ums.entity.Section;
import com.plover.ums.entity.Teacher;
import com.plover.ums.repo.SectionRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionService {
    private final SectionRepository repo;
    private final EntityManager em;

    public SectionService(SectionRepository repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public SectionDto save(SectionDto dto) {
        Section section = new Section();
        section.setSectionText(dto.getSectionText());
        section.setStatus(dto.getStatus());
        section.setStrength(dto.getStrength());

        // Efficiently set Parent references
        if (dto.getCourseId() != null) section.setCourse(em.getReference(Course.class, dto.getCourseId()));
        if (dto.getTeacherId() != null) section.setTeacher(em.getReference(Teacher.class, dto.getTeacherId()));

        Section savedSection = repo.save(section);
        dto.setSectionId(savedSection.getSectionId());
        return dto;
    }

    public List<SectionDto> findAll() {
        return repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private SectionDto mapToDto(Section s) {
        SectionDto dto = new SectionDto();
        dto.setSectionId(s.getSectionId());
        dto.setSectionText(s.getSectionText());
        dto.setStatus(s.getStatus());
        dto.setStrength(s.getStrength());
        if (s.getCourse() != null) dto.setCourseId(s.getCourse().getCourseId());
        if (s.getTeacher() != null) dto.setTeacherId(s.getTeacher().getTeacherId());
        return dto;
    }
}