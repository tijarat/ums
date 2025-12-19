package com.plover.ums.controller;

import com.plover.ums.dto.WebUserFacultyDTO;
import com.plover.ums.service.WebUserFacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-faculties")
public class WebUserFacultyController {

    private final WebUserFacultyService service;

    public WebUserFacultyController(WebUserFacultyService service) {
        this.service = service;
    }

    @PostMapping("/assign")
    public ResponseEntity<WebUserFacultyDTO> assign(@RequestBody WebUserFacultyDTO dto) {
        return ResponseEntity.ok(service.assignFaculty(dto));
    }

    @GetMapping("/user/{userId}")
    public List<WebUserFacultyDTO> getByUser(@PathVariable String userId) {
        return service.getFacultiesByUser(userId);
    }
}