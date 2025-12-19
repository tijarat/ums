package com.plover.ums.controller;

import com.plover.ums.dto.TeacherEvaluationDTO;
import com.plover.ums.service.TeacherEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher-evaluations")
public class TeacherEvaluationController {

    private final TeacherEvaluationService service;

    public TeacherEvaluationController(TeacherEvaluationService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeacherEvaluationDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<TeacherEvaluationDTO> create(@RequestBody TeacherEvaluationDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}