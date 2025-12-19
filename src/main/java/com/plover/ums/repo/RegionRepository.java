package com.plover.ums.repo;

import com.plover.ums.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> 
{
    // Custom query method to find by name if needed
    Optional<Region> findByRegionName(String regionName);
}