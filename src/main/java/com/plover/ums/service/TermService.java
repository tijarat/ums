package com.plover.ums.service;

import com.plover.ums.dto.TermDTO;
import com.plover.ums.entity.Term;
import com.plover.ums.repo.TermRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermService {

    private final TermRepository repository;

    public TermService(TermRepository repository) {
        this.repository = repository;
    }

    public List<TermDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TermDTO findById(String termCode) {
        return repository.findById(termCode)
                .map(this::toDTO)
                .orElse(null);
    }

    public TermDTO save(TermDTO dto) {
        Term term = toEntity(dto);
        return toDTO(repository.save(term));
    }

    public void delete(String termCode) {
        repository.deleteById(termCode);
    }

    // ================= MAPPERS =================

    private TermDTO toDTO(Term term) {
        TermDTO dto = new TermDTO();
        dto.setTermCode(term.getTermCode());
        dto.setTermName(term.getTermName());
        dto.setStartDate(term.getStartDate());
        dto.setEndDate(term.getEndDate());
        dto.setStatusType(term.getStatusType());
        dto.setTermOrder(term.getTermOrder());
        return dto;
    }

    private Term toEntity(TermDTO dto) {
        Term term = new Term();
        term.setTermCode(dto.getTermCode());
        term.setTermName(dto.getTermName());
        term.setStartDate(dto.getStartDate());
        term.setEndDate(dto.getEndDate());
        term.setStatusType(dto.getStatusType());
        term.setTermOrder(dto.getTermOrder());
        return term;
    }
}
