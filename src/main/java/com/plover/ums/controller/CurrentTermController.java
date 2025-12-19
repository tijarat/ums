package com.plover.ums.controller;

import com.plover.ums.dto.CurrentTermDTO;
import com.plover.ums.service.CurrentTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/current-terms")
public class CurrentTermController {

    @Autowired
    private CurrentTermService service;

    @GetMapping
    public ResponseEntity<List<CurrentTermDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<CurrentTermDTO> create(@RequestBody CurrentTermDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}