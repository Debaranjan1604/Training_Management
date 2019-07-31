package com.training.trainingmanagementsystem.repository.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.trainingmanagementsystem.bean.AddSubject;
import com.training.trainingmanagementsystem.bean.AppRole;
import com.training.trainingmanagementsystem.bean.AppUser;
import com.training.trainingmanagementsystem.bean.Subject;
import com.training.trainingmanagementsystem.bean.UserRole;
import com.training.trainingmanagementsystem.dao.AddSubjectDAO;
import com.training.trainingmanagementsystem.dao.AppRoleRepository;
import com.training.trainingmanagementsystem.dao.AppUserRepository;
import com.training.trainingmanagementsystem.dao.SubjectRepository;
import com.training.trainingmanagementsystem.dao.UserRoleRepository;

@Repository
public class SubjectDescriptionDao {
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	AddSubjectDAO AddSubjectDAO;
	
	@Autowired
	AppRoleRepository AppRoleRepository; 
	
	List<Subject> lists=new ArrayList<>();
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Subject> getAllSubject()
	{
		 lists=subjectRepository.findAll();
		
		return lists;
	}
	
	public boolean checkSubjectId(Integer id)
	{
		boolean temp=false;
		
		Optional<AddSubject> user= AddSubjectDAO.findBySubjectId(id);
		
		if(user.isPresent())
		{
			temp=true;
		}
		
		return temp;
		 
	}
	
	
	public boolean checkRole(String name)
	{
		boolean temp=false;
		
		Optional<AppRole> user= AppRoleRepository.findByRoleName(name);
		
		if(user.isPresent())
		{
			temp=true;
		}
		
		return temp;
		 
	}
	
	
	
	
	

}
