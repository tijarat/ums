package com.plover.ums.controller;

import com.plover.ums.dto.AbsentLimitDTO;
import com.plover.ums.service.AbsentLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absent-limit")
public class AbsentLimitController {

    @Autowired
    private AbsentLimitService service;

    @PostMapping
    public AbsentLimitDTO create(@RequestBody AbsentLimitDTO dto) {
        return service.save(dto);
    }

    @PutMapping
    public AbsentLimitDTO update(@RequestBody AbsentLimitDTO dto) {
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public AbsentLimitDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<AbsentLimitDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/faculty/{facultyId}")
    public List<AbsentLimitDTO> getByFaculty(@PathVariable Long facultyId) {
        return service.findByFaculty(facultyId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
