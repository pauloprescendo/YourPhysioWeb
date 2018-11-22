package com.yourphysio.repository;

import com.yourphysio.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	public Exercise findExerciseById(Long id);

}
