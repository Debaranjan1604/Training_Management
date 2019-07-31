package com.training.trainingmanagementsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.trainingmanagementsystem.bean.AppUser;
import com.training.trainingmanagementsystem.bean.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer>{

	 UserRole findByAppUser(AppUser user) ;
		
	 
}
