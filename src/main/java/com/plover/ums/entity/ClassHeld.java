package com.plover.ums.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "CLASS_HELD", schema = "UMSDM")
public class ClassHeld implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_held_seq")
    @SequenceGenerator(name = "class_held_seq", sequenceName = "CLASS_ID_SEQ", allocationSize = 1)
    @Column(name = "CLASS_ID")
    private Long classId;

    @Column(name = "CLASS_TYP", nullable = false, length = 1)
    private String classType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION_ID", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SLOT_ID", nullable = false)
    private Slot slot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TCHR_ID", nullable = false)
    private Teacher teacher;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLASS_DTE", nullable = false)
    private Date classDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALARY_MASTER_ID")
    private SalaryMaster salaryMaster;

    @Column(name = "LATE_START")
    private Integer lateStart;

    @Column(name = "EARLY_LEAVE")
    private Integer earlyLeave;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIM")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIM")
    private Date endTime;

    @Column(name = "STATUS_IND", length = 1)
    private String status;

    @Column(name = "AUTO_END_IND", length = 1)
    private String autoEndIndicator;

    @Column(name = "REMARKS", length = 250)
    private String remarks;

    // --- One-Line Getters & Setters ---
    public Long getClassId() { return classId; }
    public void setClassId(Long classId) { this.classId = classId; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }
    public Slot getSlot() { return slot; }
    public void setSlot(Slot slot) { this.slot = slot; }
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public Date getClassDate() { return classDate; }
    public void setClassDate(Date classDate) { this.classDate = classDate; }
    public SalaryMaster getSalaryMaster() { return salaryMaster; }
    public void setSalaryMaster(SalaryMaster salaryMaster) { this.salaryMaster = salaryMaster; }
    public Integer getLateStart() { return lateStart; }
    public void setLateStart(Integer lateStart) { this.lateStart = lateStart; }
    public Integer getEarlyLeave() { return earlyLeave; }
    public void setEarlyLeave(Integer earlyLeave) { this.earlyLeave = earlyLeave; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getAutoEndIndicator() { return autoEndIndicator; }
    public void setAutoEndIndicator(String autoEndIndicator) { this.autoEndIndicator = autoEndIndicator; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}