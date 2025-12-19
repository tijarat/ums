package com.plover.ums.controller;

import com.plover.ums.dto.EnvVariableDTO;
import com.plover.ums.service.EnvVariableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/env-variables")
public class EnvVariableController {

    private final EnvVariableService service;

    public EnvVariableController(EnvVariableService service) {
        this.service = service;
    }

    @GetMapping
    public List<EnvVariableDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<EnvVariableDTO> create(@RequestBody EnvVariableDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}