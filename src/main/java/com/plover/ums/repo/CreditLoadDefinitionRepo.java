package com.plover.ums.repo;

import com.plover.ums.entity.CreditLoadDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CreditLoadDefinitionRepo extends JpaRepository<CreditLoadDefinition, Long> {
    List<CreditLoadDefinition> findByFacultyId(Long facultyId);
}