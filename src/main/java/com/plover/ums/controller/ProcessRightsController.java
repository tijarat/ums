package com.plover.ums.controller;

import com.plover.ums.dto.ProcessRightsDTO;
import com.plover.ums.service.ProcessRightsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/process-rights")
public class ProcessRightsController {

    private final ProcessRightsService service;

    public ProcessRightsController(ProcessRightsService service) {
        this.service = service;
    }

    @PostMapping("/assign")
    public ResponseEntity<ProcessRightsDTO> assign(@RequestBody ProcessRightsDTO dto) {
        return ResponseEntity.ok(service.assignRight(dto));
    }

    @GetMapping("/user/{userId}")
    public List<ProcessRightsDTO> getByUser(@PathVariable Long userId) {
        return service.getRightsByUser(userId);
    }
}