package com.plover.ums.dto;

import java.io.Serializable;

public class CurrentTermDTO implements Serializable {
    private String termCode;
    private Long facultyId;
    private String facultyAbbrev;

    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public Long getFacultyId() { return facultyId; }
    public void setFacultyId(Long facultyId) { this.facultyId = facultyId; }
    public String getFacultyAbbrev() { return facultyAbbrev; }
    public void setFacultyAbbrev(String facultyAbbrev) { this.facultyAbbrev = facultyAbbrev; }
}