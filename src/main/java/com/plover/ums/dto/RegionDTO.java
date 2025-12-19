package com.plover.ums.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegionDTO 
{
    private Long regionId;
    private String regionName;
    private String regionDesc;

    public RegionDTO() {}

    public RegionDTO(Long regionId, String regionName, String regionDesc) 
    {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionDesc = regionDesc;
    }

    public Long getRegionId() { return regionId; }
    public void setRegionId(Long regionId) { this.regionId = regionId; }
    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }
    public String getRegionDesc() { return regionDesc; }
    public void setRegionDesc(String regionDesc) { this.regionDesc = regionDesc; }

    @Override
    public String toString() 
    {
        try 
        {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{\"error\":\"Could not serialize DTO to JSON\"}";
        }
    }
}