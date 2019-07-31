package com.training.trainingmanagementsystem.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id" }) })
public class UserRole {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="userRoleSequence")
    @Column(name = "Id", nullable = false)
    private Long id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", nullable = false)
    private AppUser appUser;
 
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "Role_Id", nullable = false)
    
    private Integer appRole;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public AppUser getAppUser() {
        return appUser;
    }
 
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

	public Integer getAppRole() {
		return appRole;
	}

	public void setAppRole(Integer appRole) {
		this.appRole = appRole;
	}
 
    
     
}