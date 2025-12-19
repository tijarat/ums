package com.plover.ums.controller;

import com.plover.ums.dto.RightDto;
import com.plover.ums.service.RightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rights")
public class RightController {
    private final RightService service;
    public RightController(RightService service) { this.service = service; }

    @PostMapping
    public RightDto create(@RequestBody RightDto dto) { return service.save(dto); }

    @GetMapping
    public List<String> getAll() { 
        return service.findAll().stream().map(Object::toString).toList(); 
    }
}