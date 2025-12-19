package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY", schema = "UMSDM")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private Long id;

    @Column(name = "CITY_NME", length = 50, nullable = false)
    private String name;

    @Column(name = "CITY_CDE", length = 5)
    private String code;

    @Column(name = "CITY_PHONE_PREFIX", length = 10)
    private String phonePrefix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATE_ID")
    private State state;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<SubCity> subCities;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getPhonePrefix() { return phonePrefix; }
    public void setPhonePrefix(String phonePrefix) { this.phonePrefix = phonePrefix; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public List<SubCity> getSubCities() { return subCities; }
    public void setSubCities(List<SubCity> subCities) { this.subCities = subCities; }
}
