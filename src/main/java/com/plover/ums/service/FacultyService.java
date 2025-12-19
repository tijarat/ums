package com.plover.ums.service;

import com.plover.ums.entity.Faculty;
import com.plover.ums.repo.FacultyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final FacultyRepository repo;

    public FacultyService(FacultyRepository repo) {
        this.repo = repo;
    }

    public List<Faculty> findAll() {
        return repo.findAll();
    }

    public Faculty findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Faculty save(Faculty faculty) {
        return repo.save(faculty);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

