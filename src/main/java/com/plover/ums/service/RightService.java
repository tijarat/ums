package com.plover.ums.service;

import com.plover.ums.dto.RightDto;
import com.plover.ums.entity.RightEntity;
import com.plover.ums.entity.ModuleEntity;
import com.plover.ums.repo.RightRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RightService {
    private final RightRepo repo;
    private final EntityManager em;

    public RightService(RightRepo repo, EntityManager em) { this.repo = repo; this.em = em; }

    @Transactional
    public RightDto save(RightDto dto) {
        RightEntity entity = new RightEntity();
        entity.setRightName(dto.getRightName());
        if (dto.getModuleId() != null) entity.setModule(em.getReference(ModuleEntity.class, dto.getModuleId()));
        entity = repo.save(entity);
        dto.setRightId(entity.getRightId());
        return dto;
    }

    public List<RightEntity> findAll() { return repo.findAll(); }
}