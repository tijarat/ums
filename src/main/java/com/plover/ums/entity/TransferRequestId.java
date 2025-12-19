package com.plover.ums.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TransferRequestId implements Serializable {

    @Column(name = "REG_NBR")
    private String regNbr;

    @Column(name = "PROG_ID")
    private Long progId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferRequestId that = (TransferRequestId) o;
        return Objects.equals(regNbr, that.regNbr) && Objects.equals(progId, that.progId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNbr, progId);
    }
}