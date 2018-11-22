package com.yourphysio.service;

import com.yourphysio.model.Exercise;
import com.yourphysio.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExerciseService {

	@Autowired
	ExerciseRepository exerciseRepository;

	public Exercise exerciseRegister( Exercise exercise){ return exerciseRepository.save(exercise); }

	public Collection<Exercise> exercisesFindAll(){ return exerciseRepository.findAll(); }

	public Exercise exerciseFindById(Long id){ return exerciseRepository.findExerciseById(id); }

	public void exerciseDelete(Exercise exercise){ exerciseRepository.delete(exercise); }

	public Exercise exerciseUpdate(Exercise exercise){ return exerciseRepository.save(exercise); }

}
