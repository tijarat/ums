package com.plover.ums.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UserDto 
{
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotNull(message = "activeInd is required")
    @Min(value = 0, message = "activeInd must be a valid number")
    @Max(value = 8, message = "activeInd value must be <= 8")
    private Integer activeInd; // 0/1

    @Size(max = 1)
    private String userType;

    @Size(max = 500)
    private String password;

    private LocalDate expiryDate;

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public Integer getActiveInd(){return activeInd;}
    public void setActiveInd(Integer activeInd){this.activeInd = activeInd;}
    public String getUserType(){return userType;}
    public void setUserType(String userType){this.userType = userType;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    public LocalDate getExpiryDate(){return expiryDate;}
    public void setExpiryDate(LocalDate expiryDate){this.expiryDate = expiryDate;}
}


