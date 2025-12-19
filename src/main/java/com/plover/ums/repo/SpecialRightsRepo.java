package com.plover.ums.repo;

import com.plover.ums.entity.SpecialRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialRightsRepo extends JpaRepository<SpecialRights, Long> {
}