package com.plover.ums.service;

import com.plover.ums.dto.ClassHeldDTO;
import com.plover.ums.entity.*;
import com.plover.ums.repo.ClassHeldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassHeldService {

    @Autowired
    private ClassHeldRepo repository;

    public List<ClassHeldDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ClassHeldDTO save(ClassHeldDTO dto) {
        ClassHeld entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private ClassHeldDTO convertToDTO(ClassHeld entity) {
        ClassHeldDTO dto = new ClassHeldDTO();
        dto.setClassId(entity.getClassId());
        dto.setClassType(entity.getClassType());
        dto.setClassDate(entity.getClassDate());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setStatus(entity.getStatus());
        dto.setRemarks(entity.getRemarks());
        if (entity.getSection() != null) dto.setSectionId(entity.getSection().getSectionId());
        if (entity.getSlot() != null) dto.setSlotId(entity.getSlot().getSlotId());
        if (entity.getTeacher() != null) dto.setTeacherId(entity.getTeacher().getTeacherId());
        return dto;
    }

    private ClassHeld convertToEntity(ClassHeldDTO dto) {
        ClassHeld entity = new ClassHeld();
        entity.setClassId(dto.getClassId());
        entity.setClassType(dto.getClassType());
        entity.setClassDate(dto.getClassDate());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setStatus(dto.getStatus());
        entity.setRemarks(dto.getRemarks());
        
        Section sec = new Section(); sec.setSectionId(dto.getSectionId());
        entity.setSection(sec);
        
        Slot slot = new Slot(); slot.setSlotId(dto.getSlotId());
        entity.setSlot(slot);
        
        Teacher t = new Teacher(); t.setTeacherId(dto.getTeacherId());
        entity.setTeacher(t);
        
        if(dto.getSalaryMasterId() != null) {
            SalaryMaster sm = new SalaryMaster(); sm.setSalaryMasterId(dto.getSalaryMasterId());
            entity.setSalaryMaster(sm);
        }
        return entity;
    }
}