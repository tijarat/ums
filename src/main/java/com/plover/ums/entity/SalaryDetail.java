package com.plover.ums.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "SALARY_DETAIL", schema = "UMSDM")
public class SalaryDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sal_det_seq")
    @SequenceGenerator(name = "sal_det_seq", sequenceName = "UMSDM.SALARY_DETAIL_SEQ", allocationSize = 1)
    @Column(name = "SALARY_DETAIL_ID")
    private Long salaryDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALARY_MASTER_ID", nullable = false)
    private SalaryMaster salaryMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TCHR_RTE_ID", nullable = false)
    private TeacherRte teacherRate;

    @Column(name = "CLASS_HELD_CNT", nullable = false)
    private Integer classHeldCount;

    @Column(name = "SALARY_AMT", nullable = false)
    private Integer salaryAmount;

    @Column(name = "PAID_DTE")
    private LocalDate paidDate;

    @Column(name = "PAID_AMT", nullable = false)
    private Integer paidAmount;

    @Column(name = "EXCESS_CLASS_HELD")
    private Integer excessClassHeld;

    public SalaryDetail() {}

    // Getters and Setters
    public Long getSalaryDetailId() { return salaryDetailId; }
    public void setSalaryDetailId(Long salaryDetailId) { this.salaryDetailId = salaryDetailId; }
    public SalaryMaster getSalaryMaster() { return salaryMaster; }
    public void setSalaryMaster(SalaryMaster salaryMaster) { this.salaryMaster = salaryMaster; }
    public TeacherRte getTeacherRate() { return teacherRate; }
    public void setTeacherRate(TeacherRte teacherRate) { this.teacherRate = teacherRate; }
    public Integer getClassHeldCount() { return classHeldCount; }
    public void setClassHeldCount(Integer classHeldCount) { this.classHeldCount = classHeldCount; }
    public Integer getSalaryAmount() { return salaryAmount; }
    public void setSalaryAmount(Integer salaryAmount) { this.salaryAmount = salaryAmount; }
    public LocalDate getPaidDate() { return paidDate; }
    public void setPaidDate(LocalDate paidDate) { this.paidDate = paidDate; }
    public Integer getPaidAmount() { return paidAmount; }
    public void setPaidAmount(Integer paidAmount) { this.paidAmount = paidAmount; }
    public Integer getExcessClassHeld() { return excessClassHeld; }
    public void setExcessClassHeld(Integer excessClassHeld) { this.excessClassHeld = excessClassHeld; }

    @Override
    public String toString() {
        return String.format(
            "{\"salaryDetailId\":%d,\"salaryMasterId\":%s,\"teacherRateId\":%s,\"salaryAmount\":%d,\"paidDate\":\"%s\"}",
            salaryDetailId, 
            (salaryMaster != null ? salaryMaster.getSalaryMasterId() : "null"),
            (teacherRate != null ? teacherRate.getTeacherRateId(): "null"),
            salaryAmount, paidDate
        );
    }
}