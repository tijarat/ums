package com.plover.ums.repo;

import com.plover.ums.entity.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeBoardRepo extends JpaRepository<NoticeBoard, Long> {
}