package com.spring.Spring_orm.services;

import java.util.List;

import com.spring.Spring_orm.entity.Learner;

public interface LearnerDao {

public int insert(Learner learner);
	
	public void updateLearner(Learner learner); //update
	
	public void deleteLearner(int learnerId); // delete
	
	public Learner getLearner(int learnerId); // get single data
	
	public List<Learner> getAllLearners(); // get all data
	
}
