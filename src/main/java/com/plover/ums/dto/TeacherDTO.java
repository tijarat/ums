package com.plover.ums.dto;

import java.io.Serializable;
import java.util.Date;

public class TeacherDTO implements Serializable {
    private Long teacherId;
    private String teacherName;
    private String teacherAbbr;
    private String address;
    private String phoneNumber;
    private String cellNumber;
    private String officeAddress;
    private String officePhone;
    private String email;
    private String status;
    private Date joiningDate;
    private String typeIndicator;
    private Integer teacherRate;
    private String officePhoneExt;
    private String personalWebUrl;
    private String folderName;
    private String nic;
    private Long designationId;

    // --- Compact Getters & Setters ---
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public String getTeacherAbbr() { return teacherAbbr; }
    public void setTeacherAbbr(String teacherAbbr) { this.teacherAbbr = teacherAbbr; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getCellNumber() { return cellNumber; }
    public void setCellNumber(String cellNumber) { this.cellNumber = cellNumber; }
    public String getOfficeAddress() { return officeAddress; }
    public void setOfficeAddress(String officeAddress) { this.officeAddress = officeAddress; }
    public String getOfficePhone() { return officePhone; }
    public void setOfficePhone(String officePhone) { this.officePhone = officePhone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Date getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }
    public String getTypeIndicator() { return typeIndicator; }
    public void setTypeIndicator(String typeIndicator) { this.typeIndicator = typeIndicator; }
    public Integer getTeacherRate() { return teacherRate; }
    public void setTeacherRate(Integer teacherRate) { this.teacherRate = teacherRate; }
    public String getOfficePhoneExt() { return officePhoneExt; }
    public void setOfficePhoneExt(String officePhoneExt) { this.officePhoneExt = officePhoneExt; }
    public String getPersonalWebUrl() { return personalWebUrl; }
    public void setPersonalWebUrl(String personalWebUrl) { this.personalWebUrl = personalWebUrl; }
    public String getFolderName() { return folderName; }
    public void setFolderName(String folderName) { this.folderName = folderName; }
    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }
    public Long getDesignationId() { return designationId; }
    public void setDesignationId(Long designationId) { this.designationId = designationId; }
}