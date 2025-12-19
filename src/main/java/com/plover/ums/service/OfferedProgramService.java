package com.plover.ums.service;

import com.plover.ums.dto.OfferedProgramDTO;
import com.plover.ums.entity.OfferedProgram;
import com.plover.ums.entity.Program;
import com.plover.ums.entity.Term;
import com.plover.ums.repo.OfferedProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferedProgramService {

    @Autowired
    private OfferedProgramRepository repository;

    public List<OfferedProgramDTO> findAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public OfferedProgramDTO save(OfferedProgramDTO dto) {
        OfferedProgram entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    private OfferedProgramDTO convertToDTO(OfferedProgram entity) {
        OfferedProgramDTO dto = new OfferedProgramDTO();
        dto.setOfferedProgramId(entity.getOfferedProgramId());
        if (entity.getTerm() != null) dto.setTermCode(entity.getTerm().getTermCode());
        if (entity.getProgram() != null) dto.setProgramId(entity.getProgram().getId());
        return dto;
    }

    private OfferedProgram convertToEntity(OfferedProgramDTO dto) {
        OfferedProgram entity = new OfferedProgram();
        entity.setOfferedProgramId(dto.getOfferedProgramId());
        
        Term term = new Term();
        term.setTermCode(dto.getTermCode());
        entity.setTerm(term);
        
        Program program = new Program();
        program.setId(dto.getProgramId());
        entity.setProgram(program);
        
        return entity;
    }
}