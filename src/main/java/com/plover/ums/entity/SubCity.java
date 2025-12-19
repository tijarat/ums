package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUB_CITY", schema = "UMSDM")
public class SubCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_CITY_ID")
    private Long id;

    @Column(name = "SUB_CITY_NME", length = 50, nullable = false)
    private String name;

    @Column(name = "SUB_CITY_CDE", length = 5)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private City city;

    @OneToMany(mappedBy = "subCity", cascade = CascadeType.ALL)
    private List<Organization> organizations;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Organization> getOrganizations() { return organizations; }
    public void setOrganizations(List<Organization> organizations) { this.organizations = organizations; }
}
