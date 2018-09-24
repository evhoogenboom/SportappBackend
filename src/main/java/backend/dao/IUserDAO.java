package backend.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


import backend.model.Model;

public interface IUserDAO extends CrudRepository<Model, Long> { 
	
	public List<Model> findByUsername(String username);
	
	// waarom moet hier geen functie voor create? doet save dit al??
}
