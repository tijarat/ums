package com.plover.ums.controller;

import com.plover.ums.dto.RegistrationDto;
import com.plover.ums.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> findAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<RegistrationDto> create(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}