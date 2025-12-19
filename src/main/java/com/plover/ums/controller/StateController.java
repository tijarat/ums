package com.plover.ums.controller;

import com.plover.ums.dto.StateDTO;
import com.plover.ums.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<StateDTO> getAll() {
        return stateService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> getById(@PathVariable Long id) {
        StateDTO dto = stateService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StateDTO create(@RequestBody StateDTO dto) {
        return stateService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateDTO> update(@PathVariable Long id, @RequestBody StateDTO dto) {
        StateDTO updated = stateService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
