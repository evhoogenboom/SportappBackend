package backend.service;

import java.util.List;
import java.util.Optional;

import backend.model.Routine;

public interface IRoutineService {
	
	public List<Routine> findByName(String name);
	
	public Routine create(Routine routine);
	
	public Optional<Routine> findById(Long id);
	
}
