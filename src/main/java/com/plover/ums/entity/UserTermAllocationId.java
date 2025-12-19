package com.plover.ums.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTermAllocationId implements Serializable {
    private Long userId;
    private String termCode;
}