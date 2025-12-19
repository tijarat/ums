package com.plover.ums.controller;

import com.plover.ums.dto.SalaryDetailDTO;
import com.plover.ums.service.SalaryDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary-details")
public class SalaryDetailController {
    private final SalaryDetailService service;

    public SalaryDetailController(SalaryDetailService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<SalaryDetailDTO> create(@RequestBody SalaryDetailDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}