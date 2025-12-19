package com.plover.ums.dto;

import java.time.LocalDate;

public class SalaryDetailDTO {
    private Long salaryDetailId;
    private Long salaryMasterId;
    private Long teacherRateId;
    private Integer classHeldCount;
    private Integer salaryAmount;
    private LocalDate paidDate;
    private Integer paidAmount;
    private Integer excessClassHeld;

    // Getters and Setters
    public Long getSalaryDetailId() { return salaryDetailId; }
    public void setSalaryDetailId(Long salaryDetailId) { this.salaryDetailId = salaryDetailId; }
    public Long getSalaryMasterId() { return salaryMasterId; }
    public void setSalaryMasterId(Long salaryMasterId) { this.salaryMasterId = salaryMasterId; }
    public Long getTeacherRateId() { return teacherRateId; }
    public void setTeacherRateId(Long teacherRateId) { this.teacherRateId = teacherRateId; }
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
}