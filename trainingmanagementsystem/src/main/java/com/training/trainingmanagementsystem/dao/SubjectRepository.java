package com.training.trainingmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.trainingmanagementsystem.bean.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
