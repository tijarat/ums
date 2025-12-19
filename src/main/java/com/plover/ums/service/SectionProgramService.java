package com.plover.ums.service;

import com.plover.ums.dto.SectionProgramDTO;
import com.plover.ums.entity.SectionProgram;
import com.plover.ums.entity.Section;
import com.plover.ums.entity.Program;
import com.plover.ums.repo.SectionProgramRepo;
import com.plover.ums.repo.SectionRepository;
import com.plover.ums.repo.ProgramRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SectionProgramService {

    private final SectionProgramRepo repository;
    private final SectionRepository sectionRepository;
    private final ProgramRepository programRepository;

    public SectionProgramService(SectionProgramRepo repository, 
                                 SectionRepository sectionRepository, 
                                 ProgramRepository programRepository) {
        this.repository = repository;
        this.sectionRepository = sectionRepository;
        this.programRepository = programRepository;
    }

    public List<SectionProgramDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SectionProgramDTO save(SectionProgramDTO dto) {
        Section section = sectionRepository.findById(dto.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section not found"));
        
        Program program = (dto.getProgramId() != null) ? 
                programRepository.findById(dto.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program not found")) : null;

        SectionProgram entity = SectionProgram.builder()
                .id(dto.getId())
                .section(section)
                .program(program)
                .build();

        return convertToDTO(repository.save(entity));
    }

    private SectionProgramDTO convertToDTO(SectionProgram entity) {
        return SectionProgramDTO.builder()
                .id(entity.getId())
                .sectionId(entity.getSection().getSectionId())
                .sectionName(entity.getSection().getSectionText()) 
                .programId(entity.getProgram() != null ? entity.getProgram().getId() : null)
                .programName(entity.getProgram() != null ? entity.getProgram().getName() : null)
                .build();
    }
}