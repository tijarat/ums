package com.plover.ums.controller;

import com.plover.ums.dto.RegionDTO;
import com.plover.ums.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public List<RegionDTO> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id) {
        RegionDTO dto = regionService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public RegionDTO create(@RequestBody RegionDTO dto) {
        return regionService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionDTO> update(@PathVariable Long id, @RequestBody RegionDTO dto) {
        RegionDTO updated = regionService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        regionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
