package com.training.trainingmanagementsystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="addsubject")//, uniqueConstraints = { //
        //@UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "user_name","subject_id"}),
       // })


public class AddSubject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="AddSubjectGenerator")
	private Integer id;
	
	
	

	private String CourseStatus;
	
	private String userName;
	
	private Integer subjectId;
	
	
	
	public String getCourseStatus() {
		return CourseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		CourseStatus = courseStatus;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	
	
	
	

}
