package com.plover.ums.service;

import com.plover.ums.dto.RegistrationDto;
import com.plover.ums.entity.Registration;
import com.plover.ums.entity.Student;
import com.plover.ums.entity.Term;
import com.plover.ums.repo.RegistrationRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private final RegistrationRepo repository;
    private final EntityManager entityManager;

    public RegistrationService(RegistrationRepo repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public List<RegistrationDto> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public RegistrationDto save(RegistrationDto dto) {
        Registration entity = new Registration();
        
        // Map simple fields
        entity.setStatusType(dto.getStatusType());

        // Map Foreign Keys (Proxy references)
        if (dto.getRegNbr() != null) {
            entity.setStudent(entityManager.getReference(Student.class, dto.getRegNbr()));
        }
        if (dto.getTermCode() != null) {
            entity.setTerm(entityManager.getReference(Term.class, dto.getTermCode()));
        }

        Registration saved = repository.save(entity);
        return convertToDto(saved);
    }

    private RegistrationDto convertToDto(Registration entity) {
        RegistrationDto dto = new RegistrationDto();
        dto.setRegId(entity.getRegId());
        dto.setStatusType(entity.getStatusType());
        
        // Pull codes from related entities
        if (entity.getStudent() != null) {
            dto.setRegNbr(entity.getStudent().getRegNbr());
        }
        if (entity.getTerm() != null) {
            dto.setTermCode(entity.getTerm().getTermCode());
        }
        return dto;
    }
}