package com.plover.ums.service;

import com.plover.ums.dto.TransferRequestDTO;
import com.plover.ums.entity.*;
import com.plover.ums.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransferRequestService {

    private final TransferRequestRepo repository;
    private final StudentRepo studentRepository;
    private final ProgramRepository programRepository;

    public TransferRequestService(TransferRequestRepo repository, 
                                  StudentRepo studentRepository, 
                                  ProgramRepository programRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.programRepository = programRepository;
    }

    public List<TransferRequestDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TransferRequestDTO save(TransferRequestDTO dto) {
        Student student = studentRepository.findById(dto.getRegNbr())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        Program program = programRepository.findById(dto.getProgId())
                .orElseThrow(() -> new RuntimeException("Program not found"));

        TransferRequest entity = TransferRequest.builder()
                .id(new TransferRequestId(dto.getRegNbr(), dto.getProgId()))
                .student(student)
                .program(program)
                .timestamp(LocalDateTime.now())
                .build();

        return convertToDTO(repository.save(entity));
    }

    private TransferRequestDTO convertToDTO(TransferRequest entity) {
        return TransferRequestDTO.builder()
                .regNbr(entity.getId().getRegNbr())
                .progId(entity.getId().getProgId())
                .timestamp(entity.getTimestamp())
                .studentName(entity.getStudent() != null ? entity.getStudent().getStudentName() : null)
                .programName(entity.getProgram() != null ? entity.getProgram().getName() : null)
                .build();
    }
}