package com.plover.ums.dto;

import java.io.Serializable;
import java.util.Date;

public class TermDTO implements Serializable {
    private String termCode;
    private String termName;
    private Date startDate;
    private Date endDate;
    private String statusType;
    private Integer termOrder;

    // --- Compact Getters & Setters ---
    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public String getTermName() { return termName; }
    public void setTermName(String termName) { this.termName = termName; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public String getStatusType() { return statusType; }
    public void setStatusType(String statusType) { this.statusType = statusType; }
    public Integer getTermOrder() { return termOrder; }
    public void setTermOrder(Integer termOrder) { this.termOrder = termOrder; }
}