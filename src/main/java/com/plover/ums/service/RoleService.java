package com.plover.ums.service;

import com.plover.ums.dto.RoleDto;
import com.plover.ums.entity.RightEntity;
import com.plover.ums.entity.RoleEntity;
import com.plover.ums.repo.RoleRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepo repo;
    private final EntityManager em;

    public RoleService(RoleRepo repo, EntityManager em) { this.repo = repo; this.em = em; }

    @Transactional
    public RoleDto save(RoleDto dto) {
        RoleEntity role = new RoleEntity();
        role.setRoleName(dto.getRoleName());
        
        if (dto.getRightIds() != null) {
            role.setRights(dto.getRightIds().stream()
                .map(id -> em.getReference(RightEntity.class, id))
                .collect(Collectors.toSet()));
        }
        
        role = repo.save(role);
        dto.setRoleId(role.getRoleId());
        return dto;
    }
}