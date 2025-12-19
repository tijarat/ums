package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "STATE", schema = "UMSDM")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_ID")
    private Long id;

    @Column(name = "STATE_NME", length = 100, nullable = false)
    private String name;

    @Column(name = "STATE_DESC", length = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<City> cities;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public List<City> getCities() { return cities; }
    public void setCities(List<City> cities) { this.cities = cities; }
}
