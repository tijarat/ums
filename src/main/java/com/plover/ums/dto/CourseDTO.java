package com.plover.ums.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private Long courseId;
    private String termCode;
    private Long specialCourseId;
    private String courseCode;
    private String courseName;
    private String courseAbbr;
    private Integer creditHours;
    private String typeIndicator;
    private String courseType;
    private String courseDescription;

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public Long getSpecialCourseId() { return specialCourseId; }
    public void setSpecialCourseId(Long specialCourseId) { this.specialCourseId = specialCourseId; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseAbbr() { return courseAbbr; }
    public void setCourseAbbr(String courseAbbr) { this.courseAbbr = courseAbbr; }
    public Integer getCreditHours() { return creditHours; }
    public void setCreditHours(Integer creditHours) { this.creditHours = creditHours; }
    public String getTypeIndicator() { return typeIndicator; }
    public void setTypeIndicator(String typeIndicator) { this.typeIndicator = typeIndicator; }
    public String getCourseType() { return courseType; }
    public void setCourseType(String courseType) { this.courseType = courseType; }
    public String getCourseDescription() { return courseDescription; }
    public void setCourseDescription(String courseDescription) { this.courseDescription = courseDescription; }
}