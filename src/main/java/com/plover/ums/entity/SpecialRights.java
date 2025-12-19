package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SPECIAL_RIGHTS", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class SpecialRights {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "special_rights_seq")
    @SequenceGenerator(name = "special_rights_seq", sequenceName = "UMSDM.SEQ_SPECIAL_RIGHTS_ID", allocationSize = 1)
    @Column(name = "SPECIAL_RIGHTS_ID")
    private Long id;

    @Column(name = "RIGHT_NME", length = 100)
    private String name;

    @Column(name = "RIGHT_DSC", length = 500)
    private String description;
}