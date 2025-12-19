package com.plover.ums.repo;

import com.plover.ums.entity.AcademicCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicCalendarRepo extends JpaRepository<AcademicCalendar, Long> {

    List<AcademicCalendar> findByTermCde(String termCde);

    List<AcademicCalendar> findByFacultyId(Long facultyId);
}
