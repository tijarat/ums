package com.plover.ums.controller;

import com.plover.ums.dto.OrganizationDTO;
import com.plover.ums.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService orgService;

    public OrganizationController(OrganizationService orgService) {
        this.orgService = orgService;
    }

    @GetMapping
    public List<OrganizationDTO> getAll() {
        return orgService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getById(@PathVariable Long id) {
        OrganizationDTO dto = orgService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public OrganizationDTO create(@RequestBody OrganizationDTO dto) {
        return orgService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> update(@PathVariable Long id, @RequestBody OrganizationDTO dto) {
        OrganizationDTO updated = orgService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orgService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

