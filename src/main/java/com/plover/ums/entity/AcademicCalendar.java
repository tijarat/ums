package com.plover.ums.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACADEMIC_CALENDAR", schema = "UCP")
public class AcademicCalendar implements Serializable {

    @Id
    @Column(name = "ACTIVITY_ID")
    private Long activityId;

    @Column(name = "ACTIVITY_NAME", nullable = false, length = 80)
    private String activityName;

    @Column(name = "TERM_CDE", nullable = false, length = 3)
    private String termCde;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "FACULTY_ID")
    private Long facultyId;

    public AcademicCalendar() {}

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTermCde() {
        return termCde;
    }

    public void setTermCde(String termCde) {
        this.termCde = termCde;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
}
