package com.plover.ums.controller;

import com.plover.ums.dto.RoleDto;
import com.plover.ums.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService service;
    public RoleController(RoleService service) { this.service = service; }

    @PostMapping
    public RoleDto create(@RequestBody RoleDto dto) {
        return service.save(dto);
    }
}