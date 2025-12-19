package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "BATCH", schema = "UMSDM")
public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_seq")
    @SequenceGenerator(name = "batch_seq", sequenceName = "BATCH_ID_SEQ", allocationSize = 1)
    @Column(name = "BATCH_ID")
    private Long batchId;

    @Column(name = "TERM_CDE", nullable = false, length = 3)
    private String termCode;

    @Column(name = "BATCH_NBR", nullable = false)
    private Integer batchNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROG_ID", nullable = false)
    private Program program; // Parent Table

    @Column(name = "PROG_CDE", length = 10)
    private String programCode;

    public Long getBatchId() { return batchId; }
    public void setBatchId(Long batchId) { this.batchId = batchId; }

    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }

    public Integer getBatchNumber() { return batchNumber; }
    public void setBatchNumber(Integer batchNumber) { this.batchNumber = batchNumber; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }

    public String getProgramCode() { return programCode; }
    public void setProgramCode(String programCode) { this.programCode = programCode; }
}