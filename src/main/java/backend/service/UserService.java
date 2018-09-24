package backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dao.IUserDAO;
import backend.model.Model;

@Service
public class UserService implements IService {

	
	@Autowired
	private IUserDAO iUserDAO;
	
	
	@Override
	public List<Model> findByUsername(String name) {
		return this.iUserDAO.findByUsername(name);
	}
	
	
	@Override
	public Model create(Model user) {
		// iets met assert
		
		return this.iUserDAO.save(user);
		
	}
	
	
	
	 
	
	
	
}
