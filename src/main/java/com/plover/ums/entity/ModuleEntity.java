package com.plover.ums.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "MODULES", schema = "UMSDM")
public class ModuleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_seq")
    @SequenceGenerator(name = "module_seq", sequenceName = "MODULE_ID_SEQ", allocationSize = 1)
    @Column(name = "MODULE_ID")
    private Long moduleId;

    @Column(name = "MODULE_NME", nullable = false, length = 100)
    private String moduleName;

    // --- One-Line Getters & Setters ---
    public Long getModuleId() { return moduleId; }
    public void setModuleId(Long moduleId) { this.moduleId = moduleId; }
    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }
}