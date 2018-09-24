package backend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import backend.model.Exercise;

public interface IExerciseDAO extends CrudRepository<Exercise, Long>{
	
	public List<Exercise> findByName(String name);
	
}
