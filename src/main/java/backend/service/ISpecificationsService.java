package backend.service;

import java.util.Optional;

import backend.model.Routine_Exercise_specifications;

public interface ISpecificationsService {
	 
	public Routine_Exercise_specifications create (Routine_Exercise_specifications specifications);
	
	public Optional<Routine_Exercise_specifications> findById(Long id);
}
