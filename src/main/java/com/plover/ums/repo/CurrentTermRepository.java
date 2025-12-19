package com.plover.ums.repo;

import com.plover.ums.entity.CurrentTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentTermRepository extends JpaRepository<CurrentTerm, String> {
}
