package com.plover.ums.repo;

import com.plover.ums.entity.ClassHeld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassHeldRepo extends JpaRepository<ClassHeld, Long> {
}