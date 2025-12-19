package com.plover.ums.dto;

import java.io.Serializable;
import java.util.Date;

public class ClassHeldDTO implements Serializable {
    private Long classId;
    private String classType;
    private Long sectionId;
    private Long slotId;
    private Long teacherId;
    private Date classDate;
    private Long salaryMasterId;
    private Integer lateStart;
    private Integer earlyLeave;
    private Date startTime;
    private Date endTime;
    private String status;
    private String autoEndIndicator;
    private String remarks;

    // One-line Getters/Setters
    public Long getClassId() { return classId; }
    public void setClassId(Long classId) { this.classId = classId; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
    public Long getSectionId() { return sectionId; }
    public void setSectionId(Long sectionId) { this.sectionId = sectionId; }
    public Long getSlotId() { return slotId; }
    public void setSlotId(Long slotId) { this.slotId = slotId; }
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public Date getClassDate() { return classDate; }
    public void setClassDate(Date classDate) { this.classDate = classDate; }
    public Long getSalaryMasterId() { return salaryMasterId; }
    public void setSalaryMasterId(Long salaryMasterId) { this.salaryMasterId = salaryMasterId; }
    public Integer getLateStart() { return lateStart; }
    public void setLateStart(Integer lateStart) { this.lateStart = lateStart; }
    public Integer getEarlyLeave() { return earlyLeave; }
    public void setEarlyLeave(Integer earlyLeave) { this.earlyLeave = earlyLeave; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getAutoEndIndicator() { return autoEndIndicator; }
    public void setAutoEndIndicator(String autoEndIndicator) { this.autoEndIndicator = autoEndIndicator; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}