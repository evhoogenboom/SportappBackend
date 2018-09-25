package backend.service;

import java.util.List;

import backend.model.Exercise;

public interface IExerciseService {
	
	public List<Exercise> findByName(String name);
	
	public Exercise create(Exercise exercise);
	
	public Iterable<Exercise> findAll();
	
}
