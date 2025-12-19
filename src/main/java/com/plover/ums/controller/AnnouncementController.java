package com.plover.ums.controller;

import com.plover.ums.dto.AnnouncementDTO;
import com.plover.ums.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @GetMapping
    public ResponseEntity<List<AnnouncementDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> create(@RequestBody AnnouncementDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}