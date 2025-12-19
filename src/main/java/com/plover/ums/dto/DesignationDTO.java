package com.plover.ums.dto;

public class DesignationDTO {

    private Long designationId;
    private String shortDesignation;
    private String longDesignation;

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getShortDesignation() {
        return shortDesignation;
    }

    public void setShortDesignation(String shortDesignation) {
        this.shortDesignation = shortDesignation;
    }

    public String getLongDesignation() {
        return longDesignation;
    }

    public void setLongDesignation(String longDesignation) {
        this.longDesignation = longDesignation;
    }
}
