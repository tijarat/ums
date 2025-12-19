package com.plover.ums.dto;

public class OrganizationDTO {
    private Long id;
    private String name;
    private Long subCityId;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getSubCityId() { return subCityId; }
    public void setSubCityId(Long subCityId) { this.subCityId = subCityId; }
}
