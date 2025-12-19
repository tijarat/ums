package com.plover.ums.controller;

import com.plover.ums.dto.SpecializationDTO;
import com.plover.ums.service.SpecializationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController {
    private final SpecializationService service;

    public SpecializationController(SpecializationService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<SpecializationDTO> create(@RequestBody SpecializationDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<SpecializationDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}