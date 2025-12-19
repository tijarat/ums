package com.plover.ums.controller;

import com.plover.ums.dto.BatchDTO;
import com.plover.ums.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    private BatchService service;

    @PostMapping
    public ResponseEntity<BatchDTO> create(@RequestBody BatchDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}