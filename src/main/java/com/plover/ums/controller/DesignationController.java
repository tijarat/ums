package com.plover.ums.controller;

import com.plover.ums.dto.DesignationDTO;
import com.plover.ums.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {

    @Autowired
    private DesignationService service;

    @GetMapping
    public ResponseEntity<List<DesignationDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<DesignationDTO> create(@RequestBody DesignationDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}