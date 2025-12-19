package com.plover.ums.controller;

import com.plover.ums.dto.TeacherRteDTO;
import com.plover.ums.service.TeacherRteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher-rates")
public class TeacherRteController {

    private final TeacherRteService service;

    public TeacherRteController(TeacherRteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TeacherRteDTO> create(@RequestBody TeacherRteDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<TeacherRteDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}