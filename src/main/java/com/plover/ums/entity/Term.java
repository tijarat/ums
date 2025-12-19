package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TERM", schema = "UMSDM")
public class Term {

    @Id
    @Column(name = "TERM_CDE", length = 3, nullable = false)
    private String termCode;

    @Column(name = "TERM_NME", nullable = false, length = 30)
    private String termName;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DTE", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DTE", nullable = false)
    private Date endDate;

    @Column(name = "STATUS_TYP", nullable = false, length = 1)
    private String statusType;

    @Column(name = "TERM_ORDER")
    private Integer termOrder;

    // ================= GETTERS & SETTERS =================

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Integer getTermOrder() {
        return termOrder;
    }

    public void setTermOrder(Integer termOrder) {
        this.termOrder = termOrder;
    }
}
