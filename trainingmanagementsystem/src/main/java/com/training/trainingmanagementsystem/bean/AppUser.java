package com.training.trainingmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="appUserSequence")
    @Column(name = "User_Id", nullable = false)
    private Integer userId;
 
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;
 
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;
 
    @Column(name = "Enabled", length = 1, nullable = false)
    private Integer enabled;
 
    
 
    public String getUserName() {
        return userName;
    }
 
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
 
    public Integer isEnabled() {
        return enabled;
    }
 
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
 
}