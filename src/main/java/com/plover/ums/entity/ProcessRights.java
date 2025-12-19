package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROCESS_RIGHTS", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class ProcessRights {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proc_right_seq")
    @SequenceGenerator(name = "proc_right_seq", sequenceName = "UMSDM.SEQ_PROCESS_RIGHT_ID", allocationSize = 1)
    @Column(name = "PROCESS_RIGHT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPECIAL_RIGHTS_ID", nullable = false)
    private SpecialRights specialRights;
}