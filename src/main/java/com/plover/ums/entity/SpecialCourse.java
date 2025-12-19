package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "SPECIAL_COURSE", schema = "UMSDM")
public class SpecialCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spec_course_seq")
    @SequenceGenerator(name = "spec_course_seq", sequenceName = "SPEC_COURSE_ID_SEQ", allocationSize = 1)
    @Column(name = "SPEC_COURSE_ID")
    private Long specialCourseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course;

    @Column(name = "FEE_AMT", nullable = false)
    private Integer feeAmount;

    @Column(name = "DISCOUNT_IND", nullable = false, length = 1)
    private String discountIndicator;

    // --- One-Line Getters & Setters ---
    public Long getSpecialCourseId() { return specialCourseId; }
    public void setSpecialCourseId(Long specialCourseId) { this.specialCourseId = specialCourseId; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public Integer getFeeAmount() { return feeAmount; }
    public void setFeeAmount(Integer feeAmount) { this.feeAmount = feeAmount; }
    public String getDiscountIndicator() { return discountIndicator; }
    public void setDiscountIndicator(String discountIndicator) { this.discountIndicator = discountIndicator; }
}