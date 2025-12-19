package com.plover.ums.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SLOT", schema = "UMSDM")
public class Slot implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slot_seq")
    @SequenceGenerator(name = "slot_seq", sequenceName = "UMSDM.SLOT_ID_SEQ", allocationSize = 1)
    @Column(name = "SLOT_ID")
    private Long slotId;

    @Column(name = "SLOT_NBR", nullable = false)
    private Integer slotNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_CDE", nullable = false)
    private Term term;

    @Column(name = "TIME_TXT", length = 20) private String timeText;
    @Column(name = "START_TIME", length = 4) private String startTime;
    @Column(name = "END_TIME", length = 4) private String endTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "SLOT_START_TIME") private Date slotStartTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "SLOT_END_TIME") private Date slotEndTime;

    @Column(name = "CMP_ID") private Long campusId;

    public Slot() {}

    // Compact Getters/Setters
    public Long getSlotId() { return slotId; }
    public void setSlotId(Long slotId) { this.slotId = slotId; }
    public Integer getSlotNumber() { return slotNumber; }
    public void setSlotNumber(Integer slotNumber) { this.slotNumber = slotNumber; }
    public Term getTerm() { return term; }
    public void setTerm(Term term) { this.term = term; }
    public String getTimeText() { return timeText; }
    public void setTimeText(String timeText) { this.timeText = timeText; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public Date getSlotStartTime() { return slotStartTime; }
    public void setSlotStartTime(Date slotStartTime) { this.slotStartTime = slotStartTime; }
    public Date getSlotEndTime() { return slotEndTime; }
    public void setSlotEndTime(Date slotEndTime) { this.slotEndTime = slotEndTime; }
    public Long getCampusId() { return campusId; }
    public void setCampusId(Long campusId) { this.campusId = campusId; }

    @Override
    public String toString() {
        return String.format("{\"slotId\":%d,\"slotNumber\":%d,\"termCode\":\"%s\",\"time\":\"%s\"}",
            slotId, slotNumber, (term != null ? term.getTermCode() : "null"), timeText);
    }
}