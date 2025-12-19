package com.plover.ums.controller;

import com.plover.ums.dto.StudentDTO;
import com.plover.ums.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return service.findAll();
    }
}