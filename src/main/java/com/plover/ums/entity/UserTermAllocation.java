package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER_TERM_ALLOCATION", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class UserTermAllocation {

    @EmbeddedId
    private UserTermAllocationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("termCode")
    @JoinColumn(name = "TERM_CDE")
    private Term term;

    @Column(name = "FRM_DTE")
    private LocalDate fromDate;

    @Column(name = "TO_DTE")
    private LocalDate toDate;

    @Column(name = "DISALLOW_IND", nullable = false, length = 1)
    private String disallowIndicator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
}