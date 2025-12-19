package com.plover.ums.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferRequestDTO {
    private String regNbr;
    private Long progId;
    private LocalDateTime timestamp;
    
    // Auxiliary fields for UI
    private String studentName;
    private String programName;
}