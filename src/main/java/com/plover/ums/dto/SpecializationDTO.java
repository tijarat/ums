package com.plover.ums.dto;

import java.io.Serializable;

public class SpecializationDTO implements Serializable {
    private Long spId;
    private String abbrev;
    private String description;

    // Getters and Setters
    public Long getSpId() { return spId; }
    public void setSpId(Long spId) { this.spId = spId; }
    public String getAbbrev() { return abbrev; }
    public void setAbbrev(String abbrev) { this.abbrev = abbrev; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}