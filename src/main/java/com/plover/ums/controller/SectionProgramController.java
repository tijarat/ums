package com.plover.ums.controller;

import com.plover.ums.dto.SectionProgramDTO;
import com.plover.ums.service.SectionProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/section-programs")
public class SectionProgramController {

    private final SectionProgramService service;

    public SectionProgramController(SectionProgramService service) {
        this.service = service;
    }

    @GetMapping
    public List<SectionProgramDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<SectionProgramDTO> create(@RequestBody SectionProgramDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}