package com.plover.ums.controller;

import com.plover.ums.dto.SubCityDTO;
import com.plover.ums.service.SubCityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcities")
public class SubCityController {

    private final SubCityService subCityService;

    public SubCityController(SubCityService subCityService) {
        this.subCityService = subCityService;
    }

    @GetMapping
    public List<SubCityDTO> getAll() {
        return subCityService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCityDTO> getById(@PathVariable Long id) {
        SubCityDTO dto = subCityService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public SubCityDTO create(@RequestBody SubCityDTO dto) {
        return subCityService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCityDTO> update(@PathVariable Long id, @RequestBody SubCityDTO dto) {
        SubCityDTO updated = subCityService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subCityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
