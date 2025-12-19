package com.plover.ums.service;

import com.plover.ums.dto.StudentDTO;
import com.plover.ums.entity.Program;
import com.plover.ums.entity.Specialization;
import com.plover.ums.entity.Student;
import com.plover.ums.entity.SubCity;
import com.plover.ums.repo.StudentRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepo repo;
    private final EntityManager em;

    public StudentService(StudentRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public StudentDTO save(StudentDTO dto) {
        Student s = new Student();
        s.setRegNbr(dto.getRegNbr());
        s.setStudentName(dto.getStudentName());
        s.setFatherName(dto.getFatherName());
        s.setPermanentAddress1(dto.getPermanentAddress1());
        s.setPermanentAddress2(dto.getPermanentAddress2());
        s.setPermanentAddress3(dto.getPermanentAddress3());
        s.setPermanentPhone(dto.getPermanentPhone());
        s.setDob(dto.getDob());
        s.setLocalAddress1(dto.getLocalAddress1());
        s.setLocalAddress2(dto.getLocalAddress2());
        s.setLocalAddress3(dto.getLocalAddress3());
        s.setLocalPhone(dto.getLocalPhone());
        s.setGender(dto.getGender());
        s.setCnic(dto.getCnic());
        s.setStatus(dto.getStatus() != null ? dto.getStatus() : "A");

        // Map Foreign Keys
        if (dto.getPermanentCityId() != null) s.setPermanentCity(em.getReference(SubCity.class, dto.getPermanentCityId()));
        if (dto.getLocalCityId() != null) s.setLocalCity(em.getReference(SubCity.class, dto.getLocalCityId()));
        if (dto.getProgramId() != null) s.setProgram(em.getReference(Program.class, dto.getProgramId()));
        if (dto.getCourseProgramId() != null) s.setCourseProgram(em.getReference(Program.class, dto.getCourseProgramId()));
        if (dto.getSpId() != null) s.setSpecialization(em.getReference(Specialization.class, dto.getSpId()));

        repo.save(s);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> findAll() {
        return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private StudentDTO mapToDTO(Student s) {
        StudentDTO d = new StudentDTO();
        d.setRegNbr(s.getRegNbr());
        d.setStudentName(s.getStudentName());
        d.setFatherName(s.getFatherName());
        d.setDob(s.getDob());
        d.setStatus(s.getStatus());
        if (s.getProgram() != null) d.setProgramId(s.getProgram().getId());
        if (s.getSpecialization() != null) d.setSpId(s.getSpecialization().getSpId());
        return d;
    }
}