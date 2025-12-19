package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SECTION_PROGRAM", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class SectionProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_prog_seq")
    @SequenceGenerator(name = "sec_prog_seq", sequenceName = "UMSDM.SEQ_SECTION_PROG_ID", allocationSize = 1)
    @Column(name = "SECTION_PROG_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION_ID", nullable = false)
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROG_ID")
    private Program program;
}