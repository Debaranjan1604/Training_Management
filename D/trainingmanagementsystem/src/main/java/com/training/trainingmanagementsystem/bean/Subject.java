package com.training.trainingmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="subjectGeneration")
	@Column(name="id")
	private Integer id;
	
	private String subjectname;
	
	private String subjectdescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSubjectdescription() {
		return subjectdescription;
	}

	public void setSubjectdescription(String subjectdescription) {
		this.subjectdescription = subjectdescription;
	}
	
	
	
	

}
