package com.plover.ums.dto;

import java.io.Serializable;

public class SpecialCourseDTO implements Serializable {
    private Long specialCourseId;
    private Long courseId;
    private Integer feeAmount;
    private String discountIndicator;

    public Long getSpecialCourseId() { return specialCourseId; }
    public void setSpecialCourseId(Long specialCourseId) { this.specialCourseId = specialCourseId; }
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }
    public Integer getFeeAmount() { return feeAmount; }
    public void setFeeAmount(Integer feeAmount) { this.feeAmount = feeAmount; }
    public String getDiscountIndicator() { return discountIndicator; }
    public void setDiscountIndicator(String discountIndicator) { this.discountIndicator = discountIndicator; }
}