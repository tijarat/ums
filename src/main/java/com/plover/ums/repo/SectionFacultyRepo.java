package com.plover.ums.repo;

import com.plover.ums.entity.SectionFaculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionFacultyRepo extends JpaRepository<SectionFaculty, Long> {
}