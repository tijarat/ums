package com.plover.ums.controller;

import com.plover.ums.dto.UniversityDTO;
import com.plover.ums.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<UniversityDTO> getAll() {
        return universityService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDTO> getById(@PathVariable Long id) {
        UniversityDTO dto = universityService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UniversityDTO create(@RequestBody UniversityDTO dto) {
        return universityService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDTO> update(@PathVariable Long id, @RequestBody UniversityDTO dto) {
        UniversityDTO updated = universityService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        universityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
