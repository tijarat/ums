package com.plover.ums.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherEvaluationDTO {
    private Long id;
    private String termCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double eventNumber;
    private String status;
    private String briefing;
    private Long facultyId;
}