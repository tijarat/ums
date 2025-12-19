package com.plover.ums.repo;

import com.plover.ums.entity.AbsentLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsentLimitRepo extends JpaRepository<AbsentLimit, Long> {

    List<AbsentLimit> findByFacultyId(Long facultyId);

    List<AbsentLimit> findByCreditHrs(Integer creditHrs);
}
