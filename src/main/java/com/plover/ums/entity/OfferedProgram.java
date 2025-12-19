package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "OFFERED_PROGRAM", schema = "UMSDM")
public class OfferedProgram implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "op_seq")
    @SequenceGenerator(name = "op_seq", sequenceName = "OP_ID_SEQ", allocationSize = 1)
    @Column(name = "OP_ID")
    private Long offeredProgramId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_CDE", referencedColumnName = "TERM_CDE", nullable = false)
    private Term term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROG_ID", nullable = false)
    private Program program;

    // --- One-Line Getters & Setters ---
    public Long getOfferedProgramId() { return offeredProgramId; }
    public void setOfferedProgramId(Long offeredProgramId) { this.offeredProgramId = offeredProgramId; }
    public Term getTerm() { return term; }
    public void setTerm(Term term) { this.term = term; }
    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }
}