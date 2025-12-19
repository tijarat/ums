package com.plover.ums.controller;

import com.plover.ums.dto.CreditLoadDefinitionDTO;
import com.plover.ums.service.CreditLoadDefinitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-load-definitions")
public class CreditLoadDefinitionController {

    private final CreditLoadDefinitionService service;

    public CreditLoadDefinitionController(CreditLoadDefinitionService service) {
        this.service = service;
    }

    @GetMapping
    public List<CreditLoadDefinitionDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<CreditLoadDefinitionDTO> create(@RequestBody CreditLoadDefinitionDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}