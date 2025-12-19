package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ENV_VARIABLE", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class EnvVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "env_var_seq")
    @SequenceGenerator(name = "env_var_seq", sequenceName = "UMSDM.SEQ_ENV_VAR_ID", allocationSize = 1)
    @Column(name = "ENV_VAR_ID")
    private Long id;

    @Column(name = "VAR_NME", nullable = false, length = 40)
    private String name;

    @Column(name = "VAR_VAL", nullable = false, length = 100)
    private String value;

    @Column(name = "VAR_DSC", nullable = false, length = 250)
    private String description;

    @Column(name = "VAR_TYP", nullable = false, length = 1)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
}