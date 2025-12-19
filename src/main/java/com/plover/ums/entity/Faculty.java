package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "FACULTY", schema = "UMSDM")
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_seq")
    @SequenceGenerator(name = "faculty_seq", sequenceName = "FACULTY_ID_SEQ", allocationSize = 1)
    @Column(name = "FACULTY_ID")
    private Long facultyId;

    @Column(name = "FACULTY_ABBREV", nullable = false, length = 10)
    private String facultyAbbrev;

    @Column(name = "FACULTY_NME", nullable = false, length = 80)
    private String facultyName;

    @Column(name = "FACULTY_DSC", length = 500)
    private String facultyDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CMP_ID")
    private Campus campus;

    @Column(name = "ACTIVE_STATUS", length = 1)
    private String activeStatus;

    // --- One-Line Getters & Setters ---
    public Long getFacultyId() { return facultyId; }
    public void setFacultyId(Long facultyId) { this.facultyId = facultyId; }
    public String getFacultyAbbrev() { return facultyAbbrev; }
    public void setFacultyAbbrev(String facultyAbbrev) { this.facultyAbbrev = facultyAbbrev; }
    public String getFacultyName() { return facultyName; }
    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }
    public String getFacultyDescription() { return facultyDescription; }
    public void setFacultyDescription(String facultyDescription) { this.facultyDescription = facultyDescription; }
    public Campus getCampus() { return campus; }
    public void setCampus(Campus campus) { this.campus = campus; }
    public String getActiveStatus() { return activeStatus; }
    public void setActiveStatus(String activeStatus) { this.activeStatus = activeStatus; }
}