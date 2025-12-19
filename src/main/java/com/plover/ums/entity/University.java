package com.plover.ums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UNIVERSITY", schema = "UMSDM")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNI_ID")
    private Long id;

    @Column(name = "UNI_NME", length = 50, nullable = false)
    private String name;

    @Column(name = "UNI_PREFIX", length = 2)
    private String prefix;

    @Column(name = "UNI_CDE", length = 3)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CITY_ID")
    private SubCity subCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrefix() { return prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public SubCity getSubCity() { return subCity; }
    public void setSubCity(SubCity subCity) { this.subCity = subCity; }

    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
}
