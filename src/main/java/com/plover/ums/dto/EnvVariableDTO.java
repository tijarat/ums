package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnvVariableDTO {
    private Long id;
    private String name;
    private String value;
    private String description;
    private String type;
    private Long facultyId;
    private String facultyName;
}