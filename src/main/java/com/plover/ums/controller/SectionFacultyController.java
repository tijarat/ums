package com.plover.ums.controller;

import com.plover.ums.dto.SectionFacultyDTO;
import com.plover.ums.service.SectionFacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/section-faculties")
public class SectionFacultyController {

    private final SectionFacultyService service;

    public SectionFacultyController(SectionFacultyService service) {
        this.service = service;
    }

    @GetMapping
    public List<SectionFacultyDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<SectionFacultyDTO> assign(@RequestBody SectionFacultyDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}