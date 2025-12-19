package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROGRAM", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prog_seq")
    @SequenceGenerator(name = "prog_seq", sequenceName = "UMSDM.SEQ_PROGRAM_ID", allocationSize = 1)
    @Column(name = "PROG_ID")
    private Long id;

    @Column(name = "PROG_CDE", nullable = false, length = 10)
    private String code;

    @Column(name = "PROG_NME", nullable = false, length = 60)
    private String name;

    @Column(name = "PROG_ABBR", length = 5)
    private String abbreviation;

    @Column(name = "ACCT_NBR", length = 60)
    private String accountNumber;

    @Column(name = "PROG_TYP", length = 1)
    private String type;

    @Column(name = "INT_IND", length = 10)
    private String intInd;

    // Correct Relationship Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID", referencedColumnName = "FACULTY_ID")
    private Faculty faculty;

    @Column(name = "PROGRAM_LEVEL")
    private Integer level;
}