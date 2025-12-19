package com.plover.ums.controller;

import com.plover.ums.dto.CountryDTO;
import com.plover.ums.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable Long id) {
        CountryDTO dto = countryService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CountryDTO create(@RequestBody CountryDTO dto) {
        return countryService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO dto) {
        CountryDTO updated = countryService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
