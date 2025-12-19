package com.plover.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessRightsDTO {
    private Long id;
    
    // User Info
    private Long userId;
    private String userName;

    // Rights Info
    private Long specialRightsId;
    private String rightName;
}