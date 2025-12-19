package com.plover.ums.service;

import com.plover.ums.dto.CourseDTO;
import com.plover.ums.entity.Course;
import com.plover.ums.entity.Term;
import com.plover.ums.entity.SpecialCourse;
import com.plover.ums.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepo repository;

    public List<CourseDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CourseDTO save(CourseDTO dto) {
        Course entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private CourseDTO convertToDTO(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(entity.getCourseId());
        dto.setCourseCode(entity.getCourseCode());
        dto.setCourseName(entity.getCourseName());
        dto.setCourseAbbr(entity.getCourseAbbr());
        dto.setCreditHours(entity.getCreditHours());
        dto.setTypeIndicator(entity.getTypeIndicator());
        dto.setCourseType(entity.getCourseType());
        dto.setCourseDescription(entity.getCourseDescription());
        if (entity.getTerm() != null) dto.setTermCode(entity.getTerm().getTermCode());
        if (entity.getSpecialCourse() != null) dto.setSpecialCourseId(entity.getSpecialCourse().getSpecialCourseId());
        return dto;
    }

    private Course convertToEntity(CourseDTO dto) {
        Course entity = new Course();
        entity.setCourseId(dto.getCourseId());
        entity.setCourseCode(dto.getCourseCode());
        entity.setCourseName(dto.getCourseName());
        entity.setCourseAbbr(dto.getCourseAbbr());
        entity.setCreditHours(dto.getCreditHours());
        entity.setTypeIndicator(dto.getTypeIndicator());
        entity.setCourseType(dto.getCourseType());
        entity.setCourseDescription(dto.getCourseDescription());
        
        if (dto.getTermCode() != null) {
            Term term = new Term();
            term.setTermCode(dto.getTermCode());
            entity.setTerm(term);
        }
        
        if (dto.getSpecialCourseId() != null) {
            SpecialCourse sc = new SpecialCourse();
            sc.setSpecialCourseId(dto.getSpecialCourseId());
            entity.setSpecialCourse(sc);
        }
        return entity;
    }
}