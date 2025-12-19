package com.plover.ums.dto;

import java.time.LocalDate;

public class StudentDTO {
    private String regNbr;
    private String studentName;
    private String fatherName;
    private String permanentAddress1;
    private String permanentAddress2;
    private String permanentAddress3;
    private Long permanentCityId;
    private String permanentPhone;
    private LocalDate dob;
    private String localAddress1;
    private String localAddress2;
    private String localAddress3;
    private Long localCityId;
    private String localPhone;
    private String gender;
    private Long programId;
    private Long courseProgramId;
    private String cnic;
    private Long spId;
    private String status;

    // Standard Getters and Setters
    public String getRegNbr() { return regNbr; }
    public void setRegNbr(String regNbr) { this.regNbr = regNbr; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    public String getPermanentAddress1() { return permanentAddress1; }
    public void setPermanentAddress1(String permanentAddress1) { this.permanentAddress1 = permanentAddress1; }
    public String getPermanentAddress2() { return permanentAddress2; }
    public void setPermanentAddress2(String permanentAddress2) { this.permanentAddress2 = permanentAddress2; }
    public String getPermanentAddress3() { return permanentAddress3; }
    public void setPermanentAddress3(String permanentAddress3) { this.permanentAddress3 = permanentAddress3; }
    public Long getPermanentCityId() { return permanentCityId; }
    public void setPermanentCityId(Long permanentCityId) { this.permanentCityId = permanentCityId; }
    public String getPermanentPhone() { return permanentPhone; }
    public void setPermanentPhone(String permanentPhone) { this.permanentPhone = permanentPhone; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public String getLocalAddress1() { return localAddress1; }
    public void setLocalAddress1(String localAddress1) { this.localAddress1 = localAddress1; }
    public String getLocalAddress2() { return localAddress2; }
    public void setLocalAddress2(String localAddress2) { this.localAddress2 = localAddress2; }
    public String getLocalAddress3() { return localAddress3; }
    public void setLocalAddress3(String localAddress3) { this.localAddress3 = localAddress3; }
    public Long getLocalCityId() { return localCityId; }
    public void setLocalCityId(Long localCityId) { this.localCityId = localCityId; }
    public String getLocalPhone() { return localPhone; }
    public void setLocalPhone(String localPhone) { this.localPhone = localPhone; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Long getProgramId() { return programId; }
    public void setProgramId(Long programId) { this.programId = programId; }
    public Long getCourseProgramId() { return courseProgramId; }
    public void setCourseProgramId(Long courseProgramId) { this.courseProgramId = courseProgramId; }
    public String getCnic() { return cnic; }
    public void setCnic(String cnic) { this.cnic = cnic; }
    public Long getSpId() { return spId; }
    public void setSpId(Long spId) { this.spId = spId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}