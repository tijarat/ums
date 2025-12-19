package com.plover.ums.dto;

import java.util.Date;

public class AcademicCalendarDTO {

    private Long activityId;
    private String activityName;
    private String termCde;
    private Date startDate;
    private Date endDate;
    private Long facultyId;

    public AcademicCalendarDTO() {}

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
