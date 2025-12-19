package com.plover.ums.service;

import com.plover.ums.dto.SalaryMasterDTO;
import com.plover.ums.entity.SalaryDetail;
import com.plover.ums.entity.SalaryMaster;
import com.plover.ums.entity.TeacherRte;
import com.plover.ums.repo.SalaryMasterRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

@Service
public class SalaryMasterService {
    private final SalaryMasterRepo repo;
    private final EntityManager em;

    public SalaryMasterService(SalaryMasterRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public SalaryMasterDTO saveWithDetails(SalaryMasterDTO dto) {
        // 1. Create the instance (This variable is now effectively final)
        final SalaryMaster master = new SalaryMaster(); 
        master.setGenerationDate(dto.getGenerationDate());
        master.setSalaryMonth(dto.getSalaryMonth());

        if (dto.getDetails() != null) {
            master.setDetails(dto.getDetails().stream().map(d -> {
                SalaryDetail detail = new SalaryDetail();
                detail.setSalaryMaster(master); // Reference is safe now
                detail.setTeacherRate(em.getReference(TeacherRte.class, d.getTeacherRateId()));
                detail.setSalaryAmount(d.getSalaryAmount());
                detail.setClassHeldCount(d.getClassHeldCount());
                detail.setPaidAmount(d.getPaidAmount());
                return detail;
            }).collect(Collectors.toList()));
        }

        // 2. Use a NEW variable for the result of the save operation
        SalaryMaster savedMaster = repo.save(master);

        // 3. Update the DTO with the generated ID from the saved instance
        dto.setSalaryMasterId(savedMaster.getSalaryMasterId());
        return dto;
    }
}