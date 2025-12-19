package com.plover.ums.service;

import com.plover.ums.dto.AttendanceDTO;
import com.plover.ums.entity.Attendance;
import com.plover.ums.entity.ClassHeld;
import com.plover.ums.entity.Student;
import com.plover.ums.repo.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo repository;

    public List<AttendanceDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AttendanceDTO save(AttendanceDTO dto) {
        Attendance entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private AttendanceDTO convertToDTO(Attendance entity) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setAttendId(entity.getAttendId());
        dto.setStatus(entity.getStatus());
        if (entity.getClassHeld() != null) dto.setClassId(entity.getClassHeld().getClassId());
        if (entity.getStudent() != null) dto.setRegNbr(entity.getStudent().getRegNbr());
        return dto;
    }

    private Attendance convertToEntity(AttendanceDTO dto)
    {
        Attendance entity = new Attendance();
        entity.setAttendId(dto.getAttendId());
        entity.setStatus(dto.getStatus());
        // Map Class Proxy
        ClassHeld classEntity = new ClassHeld();
        classEntity.setClassId(dto.getClassId());
        entity.setClassHeld(classEntity);
        // Map Student Proxy
        Student student = new Student();
        student.setRegNbr(dto.getRegNbr());
        entity.setStudent(student);
        return entity;
    }
}