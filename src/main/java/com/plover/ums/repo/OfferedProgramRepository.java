package com.plover.ums.repo;

import com.plover.ums.entity.OfferedProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferedProgramRepository extends JpaRepository<OfferedProgram, Long> {
}
