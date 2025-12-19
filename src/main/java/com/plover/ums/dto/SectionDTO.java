package com.plover.ums.dto;

import java.io.Serializable;

public class SectionDto implements Serializable {
    private Long sectionId;
    private Long courseId;
    private Long teacherId;
    private String sectionText;
    private String status;
    private Integer strength;

    // Getters
    public Long getSectionId() { return sectionId; }
    public Long getCourseId() { return courseId; }
    public Long getTeacherId() { return teacherId; }
    public String getSectionText() { return sectionText; }
    public String getStatus() { return status; }
    public Integer getStrength() { return strength; }

    // Setters
    public void setSectionId(Long sectionId) { this.sectionId = sectionId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public void setSectionText(String sectionText) { this.sectionText = sectionText; }
    public void setStatus(String status) { this.status = status; }
    public void setStrength(Integer strength) { this.strength = strength; }
}