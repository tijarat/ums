package com.plover.ums.controller;

import com.plover.ums.dto.SalaryMasterDTO;
import com.plover.ums.service.SalaryMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary-master")
public class SalaryMasterController {
    private final SalaryMasterService service;
    public SalaryMasterController(SalaryMasterService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<SalaryMasterDTO> create(@RequestBody SalaryMasterDTO dto) {
        return ResponseEntity.ok(service.saveWithDetails(dto));
    }
}