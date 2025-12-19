package com.plover.ums.dto;

import java.io.Serializable;

public class ModuleDTO implements Serializable {
    private Long moduleId;
    private String moduleName;

    public Long getModuleId() { return moduleId; }
    public void setModuleId(Long moduleId) { this.moduleId = moduleId; }
    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }
}