package com.training.trainingmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.trainingmanagementsystem.bean.AddSubject;

@Repository
public interface AddSubjectDAO extends JpaRepository<AddSubject, Integer>{

	
	Optional<AddSubject> findBySubjectId(Integer id); 
	
	@Query("select a from AddSubject a where a.subjectId=?1 and a.userName=?2")
	AddSubject findbySubjectIdAndUserName(Integer subjectId,String userName);
	
	Optional<List<AddSubject>> findByUserName(String userName);
	
}
