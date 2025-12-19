package com.plover.ums.dto;

import java.io.Serializable;

public class AttendanceDTO implements Serializable {
    private Long attendId;
    private Long classId;
    private String regNbr;
    private String status;

    public Long getAttendId() { return attendId; }
    public void setAttendId(Long attendId) { this.attendId = attendId; }
    public Long getClassId() { return classId; }
    public void setClassId(Long classId) { this.classId = classId; }
    public String getRegNbr() { return regNbr; }
    public void setRegNbr(String regNbr) { this.regNbr = regNbr; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}