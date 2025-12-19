package com.plover.ums.controller;

import com.plover.ums.dto.ModuleDTO;
import com.plover.ums.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService service;

    @GetMapping
    public ResponseEntity<List<ModuleDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ModuleDTO> create(@RequestBody ModuleDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}