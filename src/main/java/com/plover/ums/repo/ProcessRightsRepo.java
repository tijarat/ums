package com.plover.ums.repo;

import com.plover.ums.entity.ProcessRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProcessRightsRepo extends JpaRepository<ProcessRights, Long> {
    // Custom method to find all rights for a specific user
    List<ProcessRights> findByUserId(Long userId);
}