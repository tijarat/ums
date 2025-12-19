package com.plover.ums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CAMPUS", schema = "UMSDM")
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CMP_ID")
    private Long id;

    @Column(name = "CMP_NME", length = 50, nullable = false)
    private String name;

    @Column(name = "CMP_PREFIX", length = 2)
    private String prefix;

    @Column(name = "CMP_CDE", length = 3)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CITY_ID")
    private SubCity subCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNI_ID")
    private University university;

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

    public University getUniversity() { return university; }
    public void setUniversity(University university) { this.university = university; }
}
