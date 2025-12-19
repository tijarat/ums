package com.plover.ums.repo;

import com.plover.ums.entity.SectionProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SectionProgramRepo extends JpaRepository<SectionProgram, Long> {
    List<SectionProgram> findBySectionId(Long sectionId);
    List<SectionProgram> findByProgramId(Long programId);
}