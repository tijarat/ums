package com.plover.ums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ORGANIZATION", schema = "UMSDM")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORG_ID")
    private Long id;

    @Column(name = "ORG_NME", length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CITY_ID")
    private SubCity subCity;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SubCity getSubCity() { return subCity; }
    public void setSubCity(SubCity subCity) { this.subCity = subCity; }
}
