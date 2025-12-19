package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "NOTICE_BOARD", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq")
    @SequenceGenerator(name = "notice_seq", sequenceName = "UMSDM.SEQ_NOTICE_BOARD_ID", allocationSize = 1)
    @Column(name = "NOTICE_BOARD_ID")
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 500)
    private String title;

    @Column(name = "DSC", length = 2500)
    private String description;

    @Column(name = "FROM_DTE", nullable = false)
    private LocalDate fromDate;

    @Column(name = "TO_DTE", nullable = false)
    private LocalDate toDate;

    @Column(name = "FROM_NME", nullable = false, length = 80)
    private String fromName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_DESIGNATION_ID", nullable = false)
    private Designation designation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
}