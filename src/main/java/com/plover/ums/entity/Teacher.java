package com.plover.ums.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "TEACHER", schema = "UMSDM")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq", sequenceName = "TEACHER_ID_SEQ", allocationSize = 1)
    @Column(name = "TCHR_ID")
    private Long teacherId;

    @Column(name = "TCHR_NME", nullable = false, length = 80)
    private String teacherName;

    @Column(name = "TCHR_ABBR", length = 30)
    private String teacherAbbr;

    @Column(name = "ADDRESS_TXT", length = 100)
    private String address;

    @Column(name = "PHONE_NBR", length = 20)
    private String phoneNumber;

    @Column(name = "CELL_NBR", length = 20)
    private String cellNumber;

    @Column(name = "OFF_ADDRESS_TXT", length = 100)
    private String officeAddress;

    @Column(name = "OFF_PHONE_NBR", length = 20)
    private String officePhone;

    @Column(name = "EMAIL_TXT", length = 80)
    private String email;

    @Column(name = "STATUS_IND", nullable = false, length = 1)
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "JOINING_DTE")
    private Date joiningDate;

    @Column(name = "TYPE_IND", length = 1)
    private String typeIndicator;

    @Column(name = "TCHR_RTE")
    private Integer teacherRate;

    @Column(name = "OFFICE_PHONE_EXT", length = 4)
    private String officePhoneExt;

    @Column(name = "PERSONAL_WEB_URL", length = 128)
    private String personalWebUrl;

    @Column(name = "FOLDER_NME", length = 500)
    private String folderName;

    @Column(name = "NIC", length = 15)
    private String nic;

    // --- Relationship to Designation (Foreign Key) ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESIG_ID")
    private Designation designation;

    // --- One-Line Getters & Setters ---
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
    public Designation getDesignation() { return designation; }
    public void setDesignation(Designation designation) { this.designation = designation; }
}