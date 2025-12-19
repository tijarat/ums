package com.plover.ums.controller;

import com.plover.ums.dto.TermDTO;
import com.plover.ums.service.TermService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terms")
public class TermController {

    private final TermService service;

    public TermController(TermService service) {
        this.service = service;
    }

    @GetMapping
    public List<TermDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{termCode}")
    public ResponseEntity<TermDTO> getById(@PathVariable String termCode) {
        TermDTO dto = service.findById(termCode);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TermDTO> create(@RequestBody TermDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{termCode}")
    public ResponseEntity<TermDTO> update(
            @PathVariable String termCode,
            @RequestBody TermDTO dto) {
        dto.setTermCode(termCode);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{termCode}")
    public ResponseEntity<Void> delete(@PathVariable String termCode) {
        service.delete(termCode);
        return ResponseEntity.noContent().build();
    }
}
