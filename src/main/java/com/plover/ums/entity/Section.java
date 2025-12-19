package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "SECTION", schema = "UMSDM")
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_seq")
    @SequenceGenerator(name = "section_seq", sequenceName = "SECTION_ID_SEQ", allocationSize = 1)
    @Column(name = "SECTION_ID")
    private Long sectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course; // Parent 1: Course

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TCHR_ID", nullable = false)
    private Teacher teacher; // Parent 2: Teacher

    @Column(name = "SECTION_TXT", nullable = false, length = 6)
    private String sectionText;

    @Column(name = "STATUS_IND", nullable = false, length = 1)
    private String status;

    @Column(name = "STRENGTH_NBR", nullable = false)
    private Integer strength;

    // --- One-Line Getters & Setters ---
    public Long getSectionId() { return sectionId; }
    public void setSectionId(Long sectionId) { this.sectionId = sectionId; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public String getSectionText() { return sectionText; }
    public void setSectionText(String sectionText) { this.sectionText = sectionText; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getStrength() { return strength; }
    public void setStrength(Integer strength) { this.strength = strength; }
}