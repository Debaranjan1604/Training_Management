package com.training.trainingmanagementsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.trainingmanagementsystem.bean.AddSubject;
import com.training.trainingmanagementsystem.bean.AppRole;
import com.training.trainingmanagementsystem.bean.AppUser;
import com.training.trainingmanagementsystem.bean.RegisterationDetail;
import com.training.trainingmanagementsystem.bean.Subject;
import com.training.trainingmanagementsystem.bean.User;
import com.training.trainingmanagementsystem.bean.UserRole;
import com.training.trainingmanagementsystem.dao.AddSubjectDAO;
import com.training.trainingmanagementsystem.dao.AppRoleRepository;
import com.training.trainingmanagementsystem.dao.AppUserRepository;
import com.training.trainingmanagementsystem.dao.SubjectDescriptionDao;
import com.training.trainingmanagementsystem.dao.SubjectRepository;
import com.training.trainingmanagementsystem.dao.UserRoleRepository;

//@Controller
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
	
	
	@Autowired
	AppRoleRepository appRoleRepository;
	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	SubjectDescriptionDao SubjectDescriptionDao;
	
	@Autowired
	AddSubjectDAO addSubjectDAO;
	
	@Autowired
	SubjectRepository subjectRepository;
	
@GetMapping(value="/")
public String defaultPage()
	{
		return "index";
	}
	
	@GetMapping(value="/hello")
	
	public String print()
	{
		return "hello";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean registerPagePost(@RequestBody RegisterationDetail detail) {
 
        //model.setViewName("loginPage.jsp");
		AppRole role=new AppRole();
		
		AppUser users=new AppUser();
		
		users.setUserName(detail.getUsername());
		users.setEnabled(0);
		
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String hashedPassword = passwordEncoder.encode(detail.getPassword());
		//users.setEncrytedPassword(hashedPassword);
		users.setEncrytedPassword(detail.getPassword());
		UserRole userRole=new UserRole();
		
			//role.setRoleName(appRoleRepository.findByRoleName("ROLE_"+user.getRole_name().toUpperCase()).get().getRoleName());
			appRoleRepository.saveAndFlush(appRoleRepository.findByRoleName("ROLE_"+detail.getRole().toUpperCase()).get());	
			userRole.setAppRole(appRoleRepository.findByRoleName("ROLE_"+detail.getRole().toUpperCase()).get().getRoleId());
		
			
		appUserRepository.save(users);
		
		
		
		
		userRole.setAppUser(users);
		userRoleRepository.save(userRole);
		
		
		
		
		
        return  true;
    }
	
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public boolean userlogin(@RequestBody User user) {
		if(appUserRepository.findByUserName(user.getUsername()).get().getEncrytedPassword().equalsIgnoreCase(user.getPassword()))
		{
			//return true;
			
			if(appRoleRepository.findById((userRoleRepository.findByAppUser(appUserRepository.findByUserName(user.getUsername()).get())).getAppRole()).get().getRoleName().equals("ROLE_USER"))
			{
				return true;
			}
		}
		
		
		
		return false;
    }
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
    public boolean adminlogin(@RequestBody User user) {
   
		if(appUserRepository.findByUserName(user.getUsername()).get().getEncrytedPassword().equalsIgnoreCase(user.getPassword()))
		{
			//return true;
			
			if(appRoleRepository.findById((userRoleRepository.findByAppUser(appUserRepository.findByUserName(user.getUsername()).get())).getAppRole()).get().getRoleName().equals("ROLE_ADMIN"))
			{
				return true;
			}
		}
		
		
		
		return false;
		
    }
	
	@RequestMapping(value = "/allSubject", method = RequestMethod.GET)
    public List<Subject> allSubject() 
	{
 return subjectRepository.findAll();
		
        
    }
	
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public boolean addSubjectoolean(@RequestBody Integer id) {
 
		System.out.println("Id:"+id);
		AddSubject addSubject=new AddSubject();
		addSubject.setSubjectId(id);
        System.out.println("sa:"+SubjectDescriptionDao.checkSubjectId(id));
		if(!SubjectDescriptionDao.checkSubjectId(id))
		{
		addSubjectDAO.save(addSubject);
		
		return  true;
		}
		else
		{
			
			return false;
		}
        
    }
	
	
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
    public ModelAndView deleteSubject(@RequestParam("id") int id, ModelAndView model,HttpSession session) {
 
		addSubjectDAO.deleteById(id);
		model.setViewName("deleteSubject");
		return model;
    }
	
	@RequestMapping(value = "/deleteUserSubject", method = RequestMethod.GET)
    public ModelAndView deleteUserSubject(@RequestParam("id") int id, ModelAndView model,HttpSession session) {
 
		addSubjectDAO.deleteById(id);
		model.setViewName("deleteUserSubject");
		return model;
    }

}
