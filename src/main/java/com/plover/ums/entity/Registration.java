package com.plover.ums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTRATION", schema = "UMSDM")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_seq")
    @SequenceGenerator(name = "reg_seq", sequenceName = "UMSDM.REGISTRATION_SEQ", allocationSize = 1)
    @Column(name = "REG_ID")
    private Long regId;

    // Foreign Key Relationship for Registration Number (e.g., to a Student or Master record)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_NBR", referencedColumnName = "REG_NBR")
    private Student student;

    // Foreign Key Relationship for Term Code
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_CDE", referencedColumnName = "TERM_CDE")
    private Term term;

    @Column(name = "STATUS_TYP")
    private String statusType;

    public Registration() {}

    // Getters and Setters
    public Long getRegId() { return regId; }
    public void setRegId(Long regId) { this.regId = regId; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Term getTerm() { return term; }
    public void setTerm(Term term) { this.term = term; }

    public String getStatusType() { return statusType; }
    public void setStatusType(String statusType) { this.statusType = statusType; }

    @Override
    public String toString() {
        return "{" +
                "\"regId\":" + regId + ", " +
                "\"regNbr\":\"" + (student != null ? student.getRegNbr() : null) + "\", " +
                "\"termCode\":\"" + (term != null ? term.getTermCode() : null) + "\", " +
                "\"statusType\":\"" + statusType + "\"" +
                "}";
    }
}