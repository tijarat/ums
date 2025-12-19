package com.plover.ums.dto;

import java.util.Date;

public class SlotDTO {
    private Long slotId;
    private Integer slotNumber;
    private String termCode;
    private String timeText;
    private String startTime;
    private String endTime;
    private Date slotStartTime;
    private Date slotEndTime;
    private Long campusId;

    // Getters and Setters
    public Long getSlotId() { return slotId; }
    public void setSlotId(Long slotId) { this.slotId = slotId; }
    public Integer getSlotNumber() { return slotNumber; }
    public void setSlotNumber(Integer slotNumber) { this.slotNumber = slotNumber; }
    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public String getTimeText() { return timeText; }
    public void setTimeText(String timeText) { this.timeText = timeText; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public Date getSlotStartTime() { return slotStartTime; }
    public void setSlotStartTime(Date slotStartTime) { this.slotStartTime = slotStartTime; }
    public Date getSlotEndTime() { return slotEndTime; }
    public void setSlotEndTime(Date slotEndTime) { this.slotEndTime = slotEndTime; }
    public Long getCampusId() { return campusId; }
    public void setCampusId(Long campusId) { this.campusId = campusId; }
}