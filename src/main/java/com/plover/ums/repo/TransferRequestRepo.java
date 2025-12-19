package com.plover.ums.repo;

import com.plover.ums.entity.TransferRequest;
import com.plover.ums.entity.TransferRequestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRequestRepo extends JpaRepository<TransferRequest, TransferRequestId> {
}