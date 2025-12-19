package com.plover.ums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SPECIALIZATION", schema = "UMSDM")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spec_seq")
    @SequenceGenerator(name = "spec_seq", sequenceName = "UMSDM.SPECIALIZATION_ID_SEQ", allocationSize = 1)
    @Column(name = "SP_ID")
    private Long spId;

    @Column(name = "SPECIALIZATION_ABBREV")
    private String abbrev;

    @Column(name = "SPECIALIZATION_DESC")
    private String description;

    public Specialization() {}

    // Getters and Setters
    public Long getSpId() { return spId; }
    public void setSpId(Long spId) { this.spId = spId; }
    public String getAbbrev() { return abbrev; }
    public void setAbbrev(String abbrev) { this.abbrev = abbrev; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("{\"spId\":%d,\"abbrev\":\"%s\",\"description\":\"%s\"}", 
            spId, abbrev, description);
    }
}