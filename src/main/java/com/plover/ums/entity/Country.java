package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY", schema = "UMSDM")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    private Long id;

    @Column(name = "COUNTRY_NME", length = 100, nullable = false)
    private String name;

    @Column(name = "COUNTRY_2DC", length = 2)
    private String code2;

    @Column(name = "COUNTRY_3DC", length = 3)
    private String code3;

    @Column(name = "COUNTRY_PHONE_PREFIX", length = 6)
    private String phonePrefix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<State> states;

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

    public Region getRegion() { return region; }
    public void setRegion(Region region) { this.region = region; }

    public List<State> getStates() { return states; }
    public void setStates(List<State> states) { this.states = states; }
}
