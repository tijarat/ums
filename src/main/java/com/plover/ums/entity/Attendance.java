package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "ATTENDANCE", schema = "UMSDM")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attend_seq")
    @SequenceGenerator(name = "attend_seq", sequenceName = "ATTEND_ID_SEQ", allocationSize = 1)
    @Column(name = "ATTEND_ID")
    private Long attendId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASS_ID", nullable = false)
    private ClassHeld classObject; // Parent 1: Class

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REG_NBR", referencedColumnName = "REG_NBR", nullable = false)
    private Student student; // Parent 2: Student

    @Column(name = "STATUS_IND", nullable = false, length = 1)
    private String status;

    // --- One-Line Getters & Setters ---
    public Long getAttendId() { return attendId; }
    public void setAttendId(Long attendId) { this.attendId = attendId; }

    public ClassHeld getClassHeld() { return classObject; }
    public void setClassHeld(ClassHeld classObject) { this.classObject = classObject; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}