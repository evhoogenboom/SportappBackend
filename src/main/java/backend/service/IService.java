package backend.service;

import java.util.List;

import backend.model.Model;
import backend.model.Routine;

public interface IService {
	
	public List<Model> findByUsername(String name);
	
	public Model create(Model user);
	
	public List<Routine> getRoutines(Long id);
}
