package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSFER_REQUEST", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class TransferRequest {

    @EmbeddedId
    private TransferRequestId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("regNbr")
    @JoinColumn(name = "REG_NBR")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("progId")
    @JoinColumn(name = "PROG_ID")
    private Program program;

    @Column(name = "TMS")
    private LocalDateTime timestamp;
}