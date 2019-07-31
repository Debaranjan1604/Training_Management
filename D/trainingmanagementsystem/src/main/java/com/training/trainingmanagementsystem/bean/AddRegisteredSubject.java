package com.training.trainingmanagementsystem.bean;

public class AddRegisteredSubject 
{

private Integer sno;

private Integer id;

private String subjectName;

private String userName;

private String CourseStatus;




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

public Integer getSno() {
	return sno;
}

public void setSno(Integer sno) {
	this.sno = sno;
}

public String getSubjectName() {
	return subjectName;
}

public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}


}
