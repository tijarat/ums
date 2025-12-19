package com.plover.ums.dto;

public class CountryDTO {
    private Long id;
    private String name;
    private String code2;
    private String code3;
    private String phonePrefix;
    private Long regionId;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode2() { return code2; }
    public void setCode2(String code2) { this.code2 = code2; }

    public String getCode3() { return code3; }
    public void setCode3(String code3) { this.code3 = code3; }

    public String getPhonePrefix() { return phonePrefix; }
    public void setPhonePrefix(String phonePrefix) { this.phonePrefix = phonePrefix; }

    public Long getRegionId() { return regionId; }
    public void setRegionId(Long regionId) { this.regionId = regionId; }
}
