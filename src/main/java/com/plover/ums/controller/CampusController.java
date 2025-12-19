package com.plover.ums.controller;

import com.plover.ums.dto.CampusDTO;
import com.plover.ums.service.CampusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {

    private final CampusService campusService;

    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }

    @GetMapping
    public List<CampusDTO> getAll() {
        return campusService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampusDTO> getById(@PathVariable Long id) {
        CampusDTO dto = campusService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CampusDTO create(@RequestBody CampusDTO dto) {
        return campusService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampusDTO> update(@PathVariable Long id, @RequestBody CampusDTO dto) {
        CampusDTO updated = campusService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        campusService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
