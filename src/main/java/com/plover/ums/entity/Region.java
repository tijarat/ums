package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "REGION", schema = "UMSDM")
public class Region 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(name = "region_seq", sequenceName = "UMSDM.SEQ_REGION_ID", allocationSize = 1)
    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NME", nullable = false)
    private String regionName;

    @Column(name = "REGION_DESC")
    private String regionDesc;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Country> countries;

    public Region() {}
    public Long getRegionId() { return regionId; }
    public void setRegionId(Long regionId) { this.regionId = regionId; }
    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }
    public String getRegionDesc() { return regionDesc; }
    public void setRegionDesc(String regionDesc) { this.regionDesc = regionDesc; }
    public List<Country> getCountries() { return countries; }
    public void setCountries(List<Country> countries) { this.countries = countries; }

    @Override
    public String toString() 
    {
        try 
        {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{\"error\":\"Could not serialize to JSON\"}";
        }
    }
}