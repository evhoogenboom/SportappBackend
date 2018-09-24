package backend.service;

import java.util.List;

import backend.model.Model;

public interface IService {
	
	public List<Model> findByUsername(String name);
	
	public Model create(Model user);
}
