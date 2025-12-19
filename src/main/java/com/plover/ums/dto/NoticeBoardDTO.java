package com.plover.ums.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeBoardDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String fromName;
    
    // Relationship IDs
    private Long designationId;
    private String designationName;
    private Long facultyId;
    private String facultyName;
}