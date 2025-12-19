package com.plover.ums.dto;

import java.io.Serializable;

public class RegistrationDto implements Serializable {
    private Long regId;
    private String regNbr;
    private String termCode;
    private String statusType;

    // Default Constructor
    public RegistrationDto() {}

    // Full Constructor
    public RegistrationDto(Long regId, String regNbr, String termCode, String statusType) {
        this.regId = regId;
        this.regNbr = regNbr;
        this.termCode = termCode;
        this.statusType = statusType;
    }

    // Getters
    public Long getRegId() { return regId; }
    public String getRegNbr() { return regNbr; }
    public String getTermCode() { return termCode; }
    public String getStatusType() { return statusType; }

    // Setters
    public void setRegId(Long regId) { this.regId = regId; }
    public void setRegNbr(String regNbr) { this.regNbr = regNbr; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public void setStatusType(String statusType) { this.statusType = statusType; }
}