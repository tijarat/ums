package com.plover.ums.dto;

import java.io.Serializable;

public class TeacherRteDTO implements Serializable {
    private Long teacherRateId;
    private Long sectionId;
    private Long teacherId;
    private Integer teacherRate;

    // Getters and Setters
    public Long getTeacherRateId() { return teacherRateId; }
    public void setTeacherRateId(Long teacherRateId) { this.teacherRateId = teacherRateId; }
    public Long getSectionId() { return sectionId; }
    public void setSectionId(Long sectionId) { this.sectionId = sectionId; }
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public Integer getTeacherRate() { return teacherRate; }
    public void setTeacherRate(Integer teacherRate) { this.teacherRate = teacherRate; }
}