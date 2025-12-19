package com.plover.ums.repo;

import com.plover.ums.entity.TeacherRte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRteRepo extends JpaRepository<TeacherRte, Long> {
}