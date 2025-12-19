package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "DESIGNATION", schema = "UMSDM")
public class Designation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "desig_seq")
    @SequenceGenerator(name = "desig_seq", sequenceName = "DESIG_ID_SEQ", allocationSize = 1)
    @Column(name = "DESIG_ID")
    private Long designationId;

    @Column(name = "SHORT_DESIG", nullable = false, length = 20)
    private String shortDesignation;

    @Column(name = "LONG_DESIG", nullable = false, length = 64)
    private String longDesignation;

    // --- One-Line Getters & Setters ---
    public Long getDesignationId() { return designationId; }
    public void setDesignationId(Long designationId) { this.designationId = designationId; }
    public String getShortDesignation() { return shortDesignation; }
    public void setShortDesignation(String shortDesignation) { this.shortDesignation = shortDesignation; }
    public String getLongDesignation() { return longDesignation; }
    public void setLongDesignation(String longDesignation) { this.longDesignation = longDesignation; }
}