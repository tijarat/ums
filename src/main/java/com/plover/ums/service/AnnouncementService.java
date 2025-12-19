package com.plover.ums.service;

import com.plover.ums.dto.AnnouncementDTO;
import com.plover.ums.entity.Announcement;
import com.plover.ums.entity.Section;
import com.plover.ums.entity.Teacher;
import com.plover.ums.repo.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepo repository;

    public List<AnnouncementDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AnnouncementDTO save(AnnouncementDTO dto) {
        Announcement entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private AnnouncementDTO convertToDTO(Announcement entity) {
        AnnouncementDTO dto = new AnnouncementDTO();
        dto.setAnnouncementId(entity.getAnnouncementId());
        dto.setAnnouncementSubject(entity.getAnnouncementSubject());
        dto.setAnnouncementDescription(entity.getAnnouncementDescription());
        dto.setAnnouncementDate(entity.getAnnouncementDate());
        dto.setExpiryDate(entity.getExpiryDate());
        if (entity.getSection() != null) dto.setSectionId(entity.getSection().getSectionId());
        if (entity.getTeacher() != null) dto.setTeacherId(entity.getTeacher().getTeacherId());
        return dto;
    }

    private Announcement convertToEntity(AnnouncementDTO dto) {
        Announcement entity = new Announcement();
        entity.setAnnouncementId(dto.getAnnouncementId());
        entity.setAnnouncementSubject(dto.getAnnouncementSubject());
        entity.setAnnouncementDescription(dto.getAnnouncementDescription());
        entity.setAnnouncementDate(dto.getAnnouncementDate());
        entity.setExpiryDate(dto.getExpiryDate());
        // Handle Section Reference
        Section section = new Section();
        section.setSectionId(dto.getSectionId());
        entity.setSection(section);
        // Handle Teacher Reference
        Teacher teacher = new Teacher();
        teacher.setTeacherId(dto.getTeacherId());
        entity.setTeacher(teacher);
        return entity;
    }
}