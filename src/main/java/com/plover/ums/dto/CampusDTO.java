package com.plover.ums.dto;

public class CampusDTO {
    private Long id;
    private String name;
    private String prefix;
    private String code;
    private Long subCityId;
    private Long universityId;

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

    public Long getUniversityId() { return universityId; }
    public void setUniversityId(Long universityId) { this.universityId = universityId; }
}
