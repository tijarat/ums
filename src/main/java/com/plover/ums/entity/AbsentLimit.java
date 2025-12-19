package com.plover.ums.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ABSENT_LIMIT", schema = "UMSDM")
public class AbsentLimit implements Serializable {

    @Id
    @Column(name = "ABSENT_LIMIT_ID")
    private Long absentLimitId;

    @Column(name = "CREDIT_HRS", nullable = false)
    private Integer creditHrs;

    @Column(name = "ABSENT_LIMIT", nullable = false)
    private Integer absentLimit;

    @Column(name = "FACULTY_ID", nullable = false)
    private Long facultyId;

    @Column(name = "ABSENT_LIMIT_SPORTS", nullable = false)
    private Integer absentLimitSports;

    public AbsentLimit() {}

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
