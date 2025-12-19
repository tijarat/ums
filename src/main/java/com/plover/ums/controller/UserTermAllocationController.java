package com.plover.ums.controller;

import com.plover.ums.dto.UserTermAllocationDTO;
import com.plover.ums.service.UserTermAllocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-term-allocations")
public class UserTermAllocationController {

    private final UserTermAllocationService service;

    public UserTermAllocationController(UserTermAllocationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserTermAllocationDTO> allocate(@RequestBody UserTermAllocationDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}