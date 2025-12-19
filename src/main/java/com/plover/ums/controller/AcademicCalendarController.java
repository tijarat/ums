package com.plover.ums.controller;

import com.plover.ums.dto.AcademicCalendarDTO;
import com.plover.ums.service.AcademicCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academic-calendar")
public class AcademicCalendarController {

    @Autowired
    private AcademicCalendarService service;

    @PostMapping
    public AcademicCalendarDTO create(@RequestBody AcademicCalendarDTO dto) {
        return service.save(dto);
    }

    @PutMapping
    public AcademicCalendarDTO update(@RequestBody AcademicCalendarDTO dto) {
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public AcademicCalendarDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<AcademicCalendarDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/term/{termCde}")
    public List<AcademicCalendarDTO> getByTerm(@PathVariable String termCde) {
        return service.findByTerm(termCde);
    }

    @GetMapping("/faculty/{facultyId}")
    public List<AcademicCalendarDTO> getByFaculty(@PathVariable Long facultyId) {
        return service.findByFaculty(facultyId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
