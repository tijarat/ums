package com.plover.ums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RIGHTS")
public class RightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "right_seq")
    @SequenceGenerator(name = "right_seq", sequenceName = "RIGHTS_SEQ", allocationSize = 1)
    private Long rightId;

    private String rightName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODULE_ID")
    private ModuleEntity module;

    // Getters & Setters
    public Long getRightId() { return rightId; }
    public void setRightId(Long rightId) { this.rightId = rightId; }
    public String getRightName() { return rightName; }
    public void setRightName(String rightName) { this.rightName = rightName; }
    public ModuleEntity getModule() { return module; }
    public void setModule(ModuleEntity module) { this.module = module; }

    @Override
    public String toString() {
        return String.format("{\"rightId\":%d,\"rightName\":\"%s\",\"moduleId\":%s}", 
            rightId, rightName, (module != null ? module.getModuleId() : "null"));
    }
}