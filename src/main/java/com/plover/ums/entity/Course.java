package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "COURSE", schema = "UMSDM")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "COURSE_ID_SEQ", allocationSize = 1)
    @Column(name = "COURSE_ID")
    private Long courseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_CDE", referencedColumnName = "TERM_CDE")
    private Term term; // Parent Reference

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPECIAL_COURSE_ID")
    private SpecialCourse specialCourse; // Child/Self Reference

    @Column(name = "COURSE_CDE", nullable = false, length = 10)
    private String courseCode;

    @Column(name = "COURSE_NME", nullable = false, length = 60)
    private String courseName;

    @Column(name = "COURSE_ABBR", nullable = false, length = 10)
    private String courseAbbr;

    @Column(name = "CREDIT_HRS", nullable = false)
    private Integer creditHours;

    @Column(name = "TYP_IND", nullable = false, length = 1)
    private String typeIndicator;

    @Column(name = "COURSE_TYP", length = 1)
    private String courseType;

    @Column(name = "COURSE_DSC", length = 1500)
    private String courseDescription;

    // --- One-Line Getters & Setters ---
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public Term getTerm() { return term; }
    public void setTerm(Term term) { this.term = term; }
    public SpecialCourse getSpecialCourse() { return specialCourse; }
    public void setSpecialCourse(SpecialCourse specialCourse) { this.specialCourse = specialCourse; }
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