package com.plover.ums.service;

import com.plover.ums.dto.SalaryDetailDTO;
import com.plover.ums.entity.SalaryDetail;
import com.plover.ums.entity.SalaryMaster;
import com.plover.ums.entity.TeacherRte;
import com.plover.ums.repo.SalaryDetailRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalaryDetailService {
    private final SalaryDetailRepo repo;
    private final EntityManager em;

    public SalaryDetailService(SalaryDetailRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public SalaryDetailDTO save(SalaryDetailDTO dto) {
        SalaryDetail entity = new SalaryDetail();
        entity.setClassHeldCount(dto.getClassHeldCount());
        entity.setSalaryAmount(dto.getSalaryAmount());
        entity.setPaidDate(dto.getPaidDate());
        entity.setPaidAmount(dto.getPaidAmount());
        entity.setExcessClassHeld(dto.getExcessClassHeld());

        // Set Foreign Keys using efficient references
        if (dto.getSalaryMasterId() != null) 
            entity.setSalaryMaster(em.getReference(SalaryMaster.class, dto.getSalaryMasterId()));
        if (dto.getTeacherRateId() != null) 
            entity.setTeacherRate(em.getReference(TeacherRte.class, dto.getTeacherRateId()));

        entity = repo.save(entity);
        dto.setSalaryDetailId(entity.getSalaryDetailId());
        return dto;
    }
}