package backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import backend.dao.IExerciseDAO;
import backend.model.Exercise;

@Service
public class ExerciseService implements IExerciseService{
	
	@Autowired
	private IExerciseDAO iExerciseDAO;
	
	@Override
	public List<Exercise> findByName(String name){
		return this.iExerciseDAO.findByName(name);
	}
	
	@Override
	public Exercise create(Exercise exercise) {
		Assert.notNull(exercise, "Exercise may not be null.");
		return this.iExerciseDAO.save(exercise);
	}
	
	@Override
	public Iterable<Exercise> findAll(){
		return this.iExerciseDAO.findAll();
	}

}
