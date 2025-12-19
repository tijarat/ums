package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialRightsDTO {
    private Long id;
    private String name;
    private String description;
}