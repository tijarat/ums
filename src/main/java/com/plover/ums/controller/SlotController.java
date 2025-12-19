package com.plover.ums.controller;

import com.plover.ums.dto.SlotDTO;
import com.plover.ums.service.SlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {
    private final SlotService service;

    public SlotController(SlotService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<SlotDTO> create(@RequestBody SlotDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public List<SlotDTO> getAll() {
        return service.findAll();
    }
}