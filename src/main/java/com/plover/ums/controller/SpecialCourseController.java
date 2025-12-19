package com.plover.ums.controller;

import com.plover.ums.dto.SpecialCourseDTO;
import com.plover.ums.service.SpecialCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/special-courses")
public class SpecialCourseController {

    @Autowired
    private SpecialCourseService service;

    @GetMapping
    public ResponseEntity<List<SpecialCourseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<SpecialCourseDTO> create(@RequestBody SpecialCourseDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}