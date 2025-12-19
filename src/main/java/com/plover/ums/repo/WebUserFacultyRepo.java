package com.plover.ums.repo;

import com.plover.ums.entity.WebUserFaculty;
import com.plover.ums.entity.WebUserFacultyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WebUserFacultyRepo extends JpaRepository<WebUserFaculty, WebUserFacultyId> {
    List<WebUserFaculty> findByIdUserId(String userId);
}