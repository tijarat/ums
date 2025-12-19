package com.plover.ums.dto;

import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramDTO {
    private Long id;
    
    @NotBlank(message = "Program code is required")
    @Size(max = 10)
    private String code;
    
    @NotBlank(message = "Program name is required")
    @Size(max = 60)
    private String name;
    
    private String abbreviation;
    private String accountNumber;
    private String type;
    private String intInd;
    private Integer level;
    
    // For handling the relationship logic
    private Long facultyId;
    private String facultyName; 
}