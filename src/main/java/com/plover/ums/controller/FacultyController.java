package com.plover.ums.controller;

import com.plover.ums.entity.Faculty;
import com.plover.ums.service.FacultyService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Faculty> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Faculty get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty) {
        return service.save(faculty);
    }

    @PutMapping("/{id}")
    public Faculty update(@PathVariable Long id, @RequestBody Faculty faculty) {
        faculty.setFacultyId(id);
        return service.save(faculty);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
