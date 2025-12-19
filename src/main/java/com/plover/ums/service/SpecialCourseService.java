package com.plover.ums.service;

import com.plover.ums.dto.SpecialCourseDTO;
import com.plover.ums.entity.Course;
import com.plover.ums.entity.SpecialCourse;
import com.plover.ums.repository.SpecialCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialCourseService {

    @Autowired
    private SpecialCourseRepository repository;

    public List<SpecialCourseDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SpecialCourseDTO save(SpecialCourseDTO dto) {
        SpecialCourse entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private SpecialCourseDTO convertToDTO(SpecialCourse entity) {
        SpecialCourseDTO dto = new SpecialCourseDTO();
        dto.setSpecialCourseId(entity.getSpecialCourseId());
        dto.setFeeAmount(entity.getFeeAmount());
        dto.setDiscountIndicator(entity.getDiscountIndicator());
        if (entity.getCourse() != null) dto.setCourseId(entity.getCourse().getCourseId());
        return dto;
    }

    private SpecialCourse convertToEntity(SpecialCourseDTO dto) {
        SpecialCourse entity = new SpecialCourse();
        entity.setSpecialCourseId(dto.getSpecialCourseId());
        entity.setFeeAmount(dto.getFeeAmount());
        entity.setDiscountIndicator(dto.getDiscountIndicator());
        // Parent Reference Mapping
        Course course = new Course();
        course.setCourseId(dto.getCourseId());
        entity.setCourse(course);
        return entity;
    }
}