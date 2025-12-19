package com.plover.ums.dto;

public class UniversityDTO {
    private Long id;
    private String name;
    private String prefix;
    private String code;
    private Long subCityId;
    private Long organizationId;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrefix() { return prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Long getSubCityId() { return subCityId; }
    public void setSubCityId(Long subCityId) { this.subCityId = subCityId; }

    public Long getOrganizationId() { return organizationId; }
    public void setOrganizationId(Long organizationId) { this.organizationId = organizationId; }
}
