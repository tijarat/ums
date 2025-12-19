package com.plover.ums.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENT", schema = "UMSDM")
public class Student implements Serializable {

    @Id
    @Column(name = "REG_NBR", length = 15)
    private String regNbr;

    @Column(name = "STUDENT_NME", nullable = false, length = 80)
    private String studentName;

    @Column(name = "FATHER_NME", length = 80)
    private String fatherName;

    @Column(name = "P_ADDRESS1_TXT", length = 150)
    private String permanentAddress1;

    @Column(name = "P_ADDRESS2_TXT", length = 150)
    private String permanentAddress2;

    @Column(name = "P_ADDRESS3_TXT", length = 150)
    private String permanentAddress3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "P_CITY_ID")
    private SubCity permanentCity;

    @Column(name = "P_PHONE_NBR", length = 35)
    private String permanentPhone;

    @Column(name = "DOB_DTE")
    private LocalDate dob;

    @Column(name = "L_ADDRESS1_TXT", length = 150)
    private String localAddress1;

    @Column(name = "L_ADDRESS2_TXT", length = 150)
    private String localAddress2;

    @Column(name = "L_ADDRESS3_TXT", length = 150)
    private String localAddress3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "L_CITY_ID")
    private SubCity localCity;

    @Column(name = "L_PHONE_NBR", length = 20)
    private String localPhone;

    @Column(name = "GENDER_IND", length = 1)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROG_ID")
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_PROG_ID")
    private Program courseProgram;

    @Column(name = "CNIC", length = 15)
    private String cnic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SP_ID")
    private Specialization specialization;

    @Column(name = "STATUS_IND", nullable = false, length = 1)
    private String status = "A";

    // Default Constructor
    public Student() {}

    // Getters and Setters
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
    public SubCity getPermanentCity() { return permanentCity; }
    public void setPermanentCity(SubCity permanentCity) { this.permanentCity = permanentCity; }
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
    public SubCity getLocalCity() { return localCity; }
    public void setLocalCity(SubCity localCity) { this.localCity = localCity; }
    public String getLocalPhone() { return localPhone; }
    public void setLocalPhone(String localPhone) { this.localPhone = localPhone; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }
    public Program getCourseProgram() { return courseProgram; }
    public void setCourseProgram(Program courseProgram) { this.courseProgram = courseProgram; }
    public String getCnic() { return cnic; }
    public void setCnic(String cnic) { this.cnic = cnic; }
    public Specialization getSpecialization() { return specialization; }
    public void setSpecialization(Specialization specialization) { this.specialization = specialization; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "{\"regNbr\":\"" + regNbr + "\", \"studentName\":\"" + studentName + "\", \"status\":\"" + status + "\"}";
    }
}