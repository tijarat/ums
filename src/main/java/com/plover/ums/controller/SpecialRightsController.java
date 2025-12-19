package com.plover.ums.controller;

import com.plover.ums.dto.SpecialRightsDTO;
import com.plover.ums.service.SpecialRightsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/special-rights")
public class SpecialRightsController {

    private final SpecialRightsService service;

    public SpecialRightsController(SpecialRightsService service) {
        this.service = service;
    }

    @GetMapping
    public List<SpecialRightsDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<SpecialRightsDTO> create(@RequestBody SpecialRightsDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}