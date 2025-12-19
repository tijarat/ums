package com.plover.ums.dto;

import java.io.Serializable;

public class OfferedProgramDTO implements Serializable {
    private Long offeredProgramId;
    private String termCode;
    private Long programId;

    public Long getOfferedProgramId() { return offeredProgramId; }
    public void setOfferedProgramId(Long offeredProgramId) { this.offeredProgramId = offeredProgramId; }
    public String getTermCode() { return termCode; }
    public void setTermCode(String termCode) { this.termCode = termCode; }
    public Long getProgramId() { return programId; }
    public void setProgramId(Long programId) { this.programId = programId; }
}