package com.training.trainingmanagementsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.trainingmanagementsystem.bean.AddSubject;

@Repository
public interface AddSubjectDAO extends JpaRepository<AddSubject, Integer>{

	
	Optional<AddSubject> findBySubjectId(Integer id); 
}
