package com.plover.ums.controller;

import com.plover.ums.dto.SectionDto;
import com.plover.ums.service.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {
    private final SectionService service;

    public SectionController(SectionService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<SectionDto> create(@RequestBody SectionDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public List<SectionDto> getAll() {
        return service.findAll();
    }
}