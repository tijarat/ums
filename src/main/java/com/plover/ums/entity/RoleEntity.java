package com.plover.ums.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "ROLES", schema = "UMSDM")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "UMSDM.ROLES_SEQ", allocationSize = 1)
    private Long roleId;

    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "ROLE_RIGHTS", schema = "UMSDM",
        joinColumns = @JoinColumn(name = "ROLE_ID"),
        inverseJoinColumns = @JoinColumn(name = "RIGHT_ID")
    )
    private Set<RightEntity> rights;

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    public Set<RightEntity> getRights() { return rights; }
    public void setRights(Set<RightEntity> rights) { this.rights = rights; }

    @Override
    public String toString() {
        String rightsJson = (rights == null) ? "[]" : 
            "[" + rights.stream().map(r -> String.valueOf(r.getRightId())).collect(Collectors.joining(",")) + "]";
        return String.format("{\"roleId\":%d,\"roleName\":\"%s\",\"rightIds\":%s}", roleId, roleName, rightsJson);
    }
}