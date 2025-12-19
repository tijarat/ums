package com.plover.ums.dto;
import java.time.LocalDate;
import java.util.List;

public class SalaryMasterDTO {
    private Long salaryMasterId;
    private LocalDate generationDate;
    private String salaryMonth;
    private List<SalaryDetailDTO> details; // For nested saving

    // Standard Getters and Setters
    public Long getSalaryMasterId() { return salaryMasterId; }
    public void setSalaryMasterId(Long salaryMasterId) { this.salaryMasterId = salaryMasterId; }
    public LocalDate getGenerationDate() { return generationDate; }
    public void setGenerationDate(LocalDate generationDate) { this.generationDate = generationDate; }
    public String getSalaryMonth() { return salaryMonth; }
    public void setSalaryMonth(String salaryMonth) { this.salaryMonth = salaryMonth; }
    public List<SalaryDetailDTO> getDetails() { return details; }
    public void setDetails(List<SalaryDetailDTO> details) { this.details = details; }
}