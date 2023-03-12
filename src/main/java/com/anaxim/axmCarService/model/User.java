package com.anaxim.axmCarService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private int userCode;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String password;
    private String profileImageUrl;
    private Date joinDate;
    private Date lastLoginDate;
    private Date lastLoginDateDisplayed;
    private String profession;
    private List<String> roles;
    private boolean isActive;
    private boolean isNotLocked;

    public User() {
    }

    public User(String firstName, String lastName, String username, String email, String password, String profession) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profession = profession;
    }

    public User(int userCode,
                String firstName,
                String lastName,
                String username,
                String email,
                String password,
                String profileImageUrl,
                Date joinDate,
                Date lastLoginDate,
                Date lastLoginDateDisplayed,
                String profession,
                List<String> roles,
                boolean isActive,
                boolean isNotLocked) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.joinDate = joinDate;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginDateDisplayed = lastLoginDateDisplayed;
        this.profession = profession;
        this.roles = roles;
        this.isActive = isActive;
        this.isNotLocked = isNotLocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserCode() {
        return userCode;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastLoginDateDisplayed() {
        return lastLoginDateDisplayed;
    }

    public void setLastLoginDateDisplayed(Date lastLoginDateDisplayed) {
        this.lastLoginDateDisplayed = lastLoginDateDisplayed;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode=" + userCode +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", joinDate=" + joinDate +
                ", lastLoginDate=" + lastLoginDate +
                ", lastLoginDateDisplayed=" + lastLoginDateDisplayed +
                ", profession='" + profession + '\'' +
                ", roles=" + roles +
                ", isActive=" + isActive +
                ", isNotLocked=" + isNotLocked +
                '}';
    }
}
