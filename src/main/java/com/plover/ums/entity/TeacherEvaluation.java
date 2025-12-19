package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "TEACHER_EVALUATION", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class TeacherEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tchr_eval_seq")
    @SequenceGenerator(name = "tchr_eval_seq", sequenceName = "UMSDM.SEQ_TCHR_EVAL_ID", allocationSize = 1)
    @Column(name = "TCHR_EVAL_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_CDE", nullable = false)
    private Term term;

    @Column(name = "START_DTE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DTE", nullable = false)
    private LocalDate endDate;

    @Column(name = "EVENT_NBR", nullable = false, precision = 4, scale = 2)
    private Double eventNumber;

    @Column(name = "STATUS", nullable = false, length = 1)
    private String status;

    @Column(name = "BRIEFING", length = 4000)
    private String briefing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
}