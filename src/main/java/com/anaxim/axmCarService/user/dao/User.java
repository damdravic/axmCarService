package com.anaxim.axmCarService.user.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private int userCode;
    private String name;
    private String lastName;
    private String email;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String password;
    private String profileImageUrl;
    private Date joinDate;
    private Date lastLoginDate;
    private Date lastLoginDateDisplayed;
    private String profession;
    private String[] roles;
    private boolean isActive;
    private boolean isNotLocked;


}
