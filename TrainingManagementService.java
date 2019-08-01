package com.training.trainingmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.trainingmanagementsystem.bean.AddRegisteredSubject;
import com.training.trainingmanagementsystem.bean.AddSubject;
import com.training.trainingmanagementsystem.bean.AddSubject1;
import com.training.trainingmanagementsystem.bean.AppRole;
import com.training.trainingmanagementsystem.bean.AppUser;
import com.training.trainingmanagementsystem.bean.CheckRegister;
import com.training.trainingmanagementsystem.bean.CourseStatus;
import com.training.trainingmanagementsystem.bean.RegisterationDetail;
import com.training.trainingmanagementsystem.bean.Subject;
import com.training.trainingmanagementsystem.bean.Subscribeuser;
import com.training.trainingmanagementsystem.bean.User;
import com.training.trainingmanagementsystem.bean.UserRole;
import com.training.trainingmanagementsystem.dao.AddSubjectDAO;
import com.training.trainingmanagementsystem.dao.AppRoleRepository;
import com.training.trainingmanagementsystem.dao.AppUserRepository;
import com.training.trainingmanagementsystem.dao.SubjectRepository;
import com.training.trainingmanagementsystem.dao.UserRoleRepository;
import com.training.trainingmanagementsystem.repository.dao.SubjectDescriptionDao;


@Service
public class TrainingManagementService 
{

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
	
	@Transactional
	public boolean registerPagePost(RegisterationDetail detail) {
		 
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
	
	@Transactional
public boolean userlogin(User user) {
		
		boolean temp=false;
		try
		{
		if(appUserRepository.findByUserName(user.getUsername()).get().getEncrytedPassword().equalsIgnoreCase(user.getPassword()))
		{
			
			
			if(appRoleRepository.findById((userRoleRepository.findByAppUser(appUserRepository.findByUserName(user.getUsername()).get())).getAppRole()).get().getRoleName().equals("ROLE_USER"))
			{
				temp= true;
			}
			
		}
		}
		
		catch(Exception ex)
		{
			temp= false;
		}
		
		return temp;
		
		
    }


	@Transactional
public boolean adminlogin(User user) {
	
	boolean temp=false;
	try
	{

	if(appUserRepository.findByUserName(user.getUsername()).get().getEncrytedPassword().equalsIgnoreCase(user.getPassword()))
	{
		//return true;
		
		if(appRoleRepository.findById((userRoleRepository.findByAppUser(appUserRepository.findByUserName(user.getUsername()).get())).getAppRole()).get().getRoleName().equals("ROLE_ADMIN"))
		{
			temp= true;
		}
	}
	}
	catch(Exception ex)
	{
		temp=false;
	}
	
	
	
	return temp;
	
}

	@Transactional
public List<Subject> allSubject() 
{
return subjectRepository.findAll();
	
    
}

	@Transactional
public boolean addSubjectoolean(Subscribeuser user) {
	 
	System.out.println("Id:"+user.getId());
	AddSubject addSubject=new AddSubject();
	addSubject.setSubjectId(user.getId());
	addSubject.setUserName(user.getUsername());
	//addSubject.setSubscribeOption(true);
	addSubject.setCourseStatus("Pending");
    System.out.println("sa:"+SubjectDescriptionDao.checkSubjectId(user.getId()));
	if(!SubjectDescriptionDao.checkSubjectId(user.getId()))
	{
	addSubjectDAO.save(addSubject);
	return  true;
	}
	else
	{
		
		return false;
	}
    
}

int snonum=1;

@Transactional
public List<AddRegisteredSubject> listRegisteredSubject() {
	 
	List<AddSubject> list=addSubjectDAO.findAll();
	List<AddRegisteredSubject> list1=new ArrayList<>();
	
	list.forEach((item) -> {
		AddRegisteredSubject addRegisteredSubject=new AddRegisteredSubject();
		addRegisteredSubject.setUserName(item.getUserName());
		addRegisteredSubject.setSno(snonum++);
		addRegisteredSubject.setId(item.getId());
		addRegisteredSubject.setCourseStatus(item.getCourseStatus());
		addRegisteredSubject.setSubjectName(subjectRepository.findById(item.getSubjectId()).get().getSubjectname());
		list1.add(addRegisteredSubject);
	});
	
	return list1;
}

@Transactional
public Boolean deleteUserByAdmin( int id) {
	 
	addSubjectDAO.deleteById(id);
	if(!addSubjectDAO.findById(id).isPresent())
	return true;
	else
		return true;
}
@Transactional
public  List<CheckRegister> checkRegister(String username) {
	
	List<CheckRegister> list1=new ArrayList<>();
try
{
List<AddSubject> list=addSubjectDAO.findByUserName(username).get();


list.forEach((item) -> {
 CheckRegister checkRegister=new CheckRegister();
checkRegister.setSubjectName( subjectRepository.findById(item.getSubjectId()).get().getSubjectname());
//checkRegister.setUsername(item.getUserName());
list1.add(checkRegister);

});
return list1;
}

catch(Exception ex)
{
	return list1;	
}

	
}

@Transactional
public boolean deleteSubject(int id) {
	 
	addSubjectDAO.deleteById(addSubjectDAO.findBySubjectId(id).get().getId());
	
	return true;
}

@Transactional
public boolean updateCourseStatus(AddSubject1 addSubject1) 
{

	AddSubject addSubject=new AddSubject();
	addSubject.setId(addSubject1.getId());
	addSubject.setCourseStatus(addSubject1.getCourseStatus());
	System.out.println("admin:"+addSubject1.getCourseStatus());
	addSubject.setUserName(addSubject1.getUserName());
	addSubject.setSubjectId(subjectRepository.findBySubjectname(addSubject1.getSubjectName()).get().getId());
	AddSubject subject1=addSubjectDAO.saveAndFlush(addSubject);
	if(subject1!=null)
	return true;
	else
		return false;
}

@Transactional
public List<CourseStatus> courseStatus(String username) 
{
System.out.println("username: "+username);	
List<AddSubject> list=addSubjectDAO.findAll();

List<CourseStatus> list1=new ArrayList<>();

list.forEach((item) -> {
	if(item.getUserName().equalsIgnoreCase(username))
	{
	CourseStatus courseStatus=new CourseStatus();
	courseStatus.setCourseStatus(item.getCourseStatus());
	courseStatus.setCourseName(subjectRepository.findById(item.getSubjectId()).get().getSubjectname());
	list1.add(courseStatus);
	}
}
);
return list1;	
}







	
}
