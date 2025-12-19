package com.plover.ums.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "WEB_USERS", schema = "UMSDM")
public class UserEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "web_users_seq")
    @SequenceGenerator(name = "web_users_seq", sequenceName = "UMSDM.WEB_USERS_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NME", length = 30)
    private String username;

    @Column(name = "ACTIVE_IND")
    private Integer activeInd;

    @Column(name = "USER_TYPE", length = 1)
    private String userType;

    @Column(name = "PASSWORD", length = 500)
    private String password;

    @Column(name = "EXPIRY_DTE")
    private LocalDate expiryDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "USER_ROLES",
        schema = "UMSDM",           // <-- add this
        joinColumns = @JoinColumn(name = "USER_ID"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<RoleEntity> roles;    

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Integer getActiveInd() { return activeInd; }
    public void setActiveInd(Integer activeInd) { this.activeInd = activeInd; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    
    public Set<RoleEntity> getRoles() { return roles; }
    public void setRoles(Set<RoleEntity> roles) { this.roles = roles; }
}
