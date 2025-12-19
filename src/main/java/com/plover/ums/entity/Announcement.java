package com.plover.ums.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ANNOUNCEMENT", schema = "UMSDM")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "announcement_seq")
    @SequenceGenerator(name = "announcement_seq", sequenceName = "ANNOUNCEMENT_ID_SEQ", allocationSize = 1)
    @Column(name = "ANNOUNCEMENT_ID", nullable = false)
    private Long announcementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION_ID", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TCHR_ID", nullable = false)
    private Teacher teacher;

    @Column(name = "ANNOUNCEMENT_SBJ", length = 50, nullable = false)
    private String announcementSubject;

    @Temporal(TemporalType.DATE)
    @Column(name = "ANNOUNCEMENT_DTE", nullable = false)
    private Date announcementDate;

    @Column(name = "ANNOUNCEMENT_DSC", length = 500)
    private String announcementDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRY_DTE")
    private Date expiryDate;

    public Long getAnnouncementId() { return announcementId; }
    public void setAnnouncementId(Long announcementId) { this.announcementId = announcementId; }

    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public String getAnnouncementSubject() { return announcementSubject; }
    public void setAnnouncementSubject(String announcementSubject) { this.announcementSubject = announcementSubject; }

    public Date getAnnouncementDate() { return announcementDate; }
    public void setAnnouncementDate(Date announcementDate) { this.announcementDate = announcementDate; }

    public String getAnnouncementDescription() { return announcementDescription; }
    public void setAnnouncementDescription(String announcementDescription) { this.announcementDescription = announcementDescription; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
}