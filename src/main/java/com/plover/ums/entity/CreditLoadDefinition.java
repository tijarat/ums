package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CREDIT_LOAD_DEFINITION", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class CreditLoadDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cld_seq")
    @SequenceGenerator(name = "cld_seq", sequenceName = "UMSDM.SEQ_CREDIT_LOAD_DEF_ID", allocationSize = 1)
    @Column(name = "CREDIT_LOAD_DEFINITION_ID")
    private Long id;

    @Column(name = "CREDIT_HRS", nullable = false, precision = 2)
    private Integer creditHours;

    @Column(name = "CLASS_LIMIT", nullable = false, precision = 3)
    private Integer classLimit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
}