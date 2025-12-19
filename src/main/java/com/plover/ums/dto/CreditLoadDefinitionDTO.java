package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditLoadDefinitionDTO {
    private Long id;
    private Integer creditHours;
    private Integer classLimit;
    private Long facultyId;
    private String facultyName;
}