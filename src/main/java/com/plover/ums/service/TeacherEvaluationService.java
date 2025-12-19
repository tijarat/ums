package com.plover.ums.service;

import com.plover.ums.dto.TeacherEvaluationDTO;
import com.plover.ums.entity.TeacherEvaluation;
import com.plover.ums.entity.Term;
import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.TeacherEvaluationRepo;
import com.plover.ums.repo.TermRepository;
import com.plover.ums.repo.FacultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeacherEvaluationService {

    private final TeacherEvaluationRepo repository;
    private final TermRepository termRepository;
    private final FacultyRepository facultyRepository;

    public TeacherEvaluationService(TeacherEvaluationRepo repository, 
                                    TermRepository termRepository, 
                                    FacultyRepository facultyRepository) {
        this.repository = repository;
        this.termRepository = termRepository;
        this.facultyRepository = facultyRepository;
    }

    public List<TeacherEvaluationDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TeacherEvaluationDTO save(TeacherEvaluationDTO dto) {
        TeacherEvaluation entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private TeacherEvaluationDTO convertToDTO(TeacherEvaluation entity) {
        return TeacherEvaluationDTO.builder()
                .id(entity.getId())
                .termCode(entity.getTerm().getTermCode())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .eventNumber(entity.getEventNumber())
                .status(entity.getStatus())
                .briefing(entity.getBriefing())
                .facultyId(entity.getFaculty() != null ? entity.getFaculty().getFacultyId() : null)
                .build();
    }

    private TeacherEvaluation convertToEntity(TeacherEvaluationDTO dto) {
        Term term = termRepository.findById(dto.getTermCode())
                .orElseThrow(() -> new RuntimeException("Term not found"));
        
        TeacherEvaluation entity = TeacherEvaluation.builder()
                .id(dto.getId())
                .term(term)
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .eventNumber(dto.getEventNumber())
                .status(dto.getStatus())
                .briefing(dto.getBriefing())
                .build();

        if (dto.getFacultyId() != null) {
            Faculty faculty = facultyRepository.findById(dto.getFacultyId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found"));
            entity.setFaculty(faculty);
        }
        return entity;
    }
}