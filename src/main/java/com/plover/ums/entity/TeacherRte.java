package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "TEACHER_RTE", schema = "UMSDM")
public class TeacherRte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tchr_rte_seq")
    @SequenceGenerator(name = "tchr_rte_seq", sequenceName = "UMSDM.TEACHER_RTE_SEQ", allocationSize = 1)
    @Column(name = "TCHR_RTE_ID", nullable = false)
    private Long teacherRateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION_ID", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TCHR_ID", nullable = false)
    private Teacher teacher;

    @Column(name = "TCHR_RTE", nullable = false)
    private Integer teacherRate;

    public TeacherRte() {}

    // Getters and Setters
    public Long getTeacherRateId() { return teacherRateId; }
    public void setTeacherRateId(Long teacherRateId) { this.teacherRateId = teacherRateId; }
    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public Integer getTeacherRate() { return teacherRate; }
    public void setTeacherRate(Integer teacherRate) { this.teacherRate = teacherRate; }
}