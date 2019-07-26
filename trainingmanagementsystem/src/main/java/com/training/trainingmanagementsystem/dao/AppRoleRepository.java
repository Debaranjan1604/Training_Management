package com.training.trainingmanagementsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.trainingmanagementsystem.bean.AppRole;


@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Integer>{

	Optional<AppRole> findByRoleName(String str);
	//AppRole findByRoleName(String str);
	
	
	
	
}
