package com.plover.ums.controller;

import com.plover.ums.dto.OfferedProgramDTO;
import com.plover.ums.service.OfferedProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offered-programs")
public class OfferedProgramController {

    @Autowired
    private OfferedProgramService service;

    @GetMapping
    public ResponseEntity<List<OfferedProgramDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<OfferedProgramDTO> create(@RequestBody OfferedProgramDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}