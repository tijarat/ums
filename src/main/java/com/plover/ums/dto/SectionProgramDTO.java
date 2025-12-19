package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectionProgramDTO {
    private Long id;
    private Long sectionId;
    private String sectionName;
    private Long programId;
    private String programName;
}