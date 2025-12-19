package com.plover.ums.dto;

import java.io.Serializable;
import java.util.Date;

public class AnnouncementDTO implements Serializable {
    private Long announcementId;
    private Long sectionId;
    private Long teacherId;
    private String announcementSubject;
    private Date announcementDate;
    private String announcementDescription;
    private Date expiryDate;

    // One-line Getters/Setters
    public Long getAnnouncementId() { return announcementId; }
    public void setAnnouncementId(Long announcementId) { this.announcementId = announcementId; }
    public Long getSectionId() { return sectionId; }
    public void setSectionId(Long sectionId) { this.sectionId = sectionId; }
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public String getAnnouncementSubject() { return announcementSubject; }
    public void setAnnouncementSubject(String announcementSubject) { this.announcementSubject = announcementSubject; }
    public Date getAnnouncementDate() { return announcementDate; }
    public void setAnnouncementDate(Date announcementDate) { this.announcementDate = announcementDate; }
    public String getAnnouncementDescription() { return announcementDescription; }
    public void setAnnouncementDescription(String announcementDescription) { this.announcementDescription = announcementDescription; }
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
}