package com.plover.ums.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "SALARY_MASTER", schema = "UMSDM")
public class SalaryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sal_mast_seq")
    @SequenceGenerator(name = "sal_mast_seq", sequenceName = "UMSDM.SALARY_MASTER_SEQ", allocationSize = 1)
    @Column(name = "SALARY_MASTER_ID")
    private Long salaryMasterId;

    @Column(name = "SALARY_GEN_DTE")
    private LocalDate generationDate;

    @Column(name = "SALARY_MONTH")
    private String salaryMonth;

    @OneToMany(mappedBy = "salaryMaster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalaryDetail> details = new ArrayList<>();

    // Getters and Setters
    public Long getSalaryMasterId() { return salaryMasterId; }
    public void setSalaryMasterId(Long salaryMasterId) { this.salaryMasterId = salaryMasterId; }
    public LocalDate getGenerationDate() { return generationDate; }
    public void setGenerationDate(LocalDate generationDate) { this.generationDate = generationDate; }
    public String getSalaryMonth() { return salaryMonth; }
    public void setSalaryMonth(String salaryMonth) { this.salaryMonth = salaryMonth; }
    public List<SalaryDetail> getDetails() { return details; }
    public void setDetails(List<SalaryDetail> details) { this.details = details; }

    @Override
    public String toString() {
        return String.format("{\"salaryMasterId\":%d,\"month\":\"%s\",\"detailCount\":%d}", 
            salaryMasterId, salaryMonth, (details != null ? details.size() : 0));
    }
}