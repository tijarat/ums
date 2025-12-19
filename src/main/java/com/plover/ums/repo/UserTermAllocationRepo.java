package com.plover.ums.repo;

import com.plover.ums.entity.UserTermAllocation;
import com.plover.ums.entity.UserTermAllocationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTermAllocationRepo extends JpaRepository<UserTermAllocation, UserTermAllocationId> {
}