package com.plover.ums.repo;

import com.plover.ums.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends JpaRepository<ModuleEntity, Long> {
}