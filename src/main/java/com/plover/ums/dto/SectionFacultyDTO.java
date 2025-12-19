package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectionFacultyDTO {
    private Long sectionId;
    private String sectionName;
    private Long facultyId;
    private String facultyName;
}