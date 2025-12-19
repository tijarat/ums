package com.plover.ums.dto;

public class AbsentLimitDTO {

    private Long absentLimitId;
    private Integer creditHrs;
    private Integer absentLimit;
    private Long facultyId;
    private Integer absentLimitSports;

    public AbsentLimitDTO() {}

    public Long getAbsentLimitId() {
        return absentLimitId;
    }

    public void setAbsentLimitId(Long absentLimitId) {
        this.absentLimitId = absentLimitId;
    }

    public Integer getCreditHrs() {
        return creditHrs;
    }

    public void setCreditHrs(Integer creditHrs) {
        this.creditHrs = creditHrs;
    }

    public Integer getAbsentLimit() {
        return absentLimit;
    }

    public void setAbsentLimit(Integer absentLimit) {
        this.absentLimit = absentLimit;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getAbsentLimitSports() {
        return absentLimitSports;
    }

    public void setAbsentLimitSports(Integer absentLimitSports) {
        this.absentLimitSports = absentLimitSports;
    }
}
