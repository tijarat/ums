package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "CURRENT_TERM", schema = "UMSDM")
public class CurrentTerm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TERM_CDE", length = 3)
    private String termCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_CDE", referencedColumnName = "TERM_CDE", insertable = false, updatable = false)
    private Term term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;

    @Column(name = "FACULTY_ABBREV", length = 10)
    private String facultyAbbrev;

    // --- One-Line Getters & Setters ---
    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public Term getTerm() { return term; }
    public void setTerm(Term term) { this.term = term; }
    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }
    public String getFacultyAbbrev() { return facultyAbbrev; }
    public void setFacultyAbbrev(String facultyAbbrev) { this.facultyAbbrev = facultyAbbrev; }
}