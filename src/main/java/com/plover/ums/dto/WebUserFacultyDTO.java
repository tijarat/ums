package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUserFacultyDTO {
    private Long userId;
    private String userName;
    private Long facultyId;
    private String facultyName;
}