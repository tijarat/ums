package com.plover.ums.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTermAllocationDTO {
    private Long userId;
    private String termCode;
    private String termName;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String disallowIndicator;
    private Long facultyId;
}