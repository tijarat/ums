package com.plover.ums.dto;
import java.util.Set;

public class RoleDto {
    private Long roleId;
    private String roleName;
    private Set<Long> rightIds; // Just IDs to keep payload small

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    public Set<Long> getRightIds() { return rightIds; }
    public void setRightIds(Set<Long> rightIds) { this.rightIds = rightIds; }
}