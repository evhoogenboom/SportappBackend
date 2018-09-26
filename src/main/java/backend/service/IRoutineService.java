package backend.service;

import java.util.List;
import java.util.Optional;

import backend.model.Routine;
import backend.model.Routine_Exercise_specifications;

public interface IRoutineService {
	
	public List<Routine> findByName(String name);
	
	public Routine create(Routine routine);
	
	public Optional<Routine> findById(Long id);
	
	public List<Routine_Exercise_specifications> getSpecifications(Long id);
	
	public void deleteRoutine(Long id);
	
}
