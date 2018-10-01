package backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import backend.dao.IUserDAO;
import backend.model.Model;
import backend.model.Routine;

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
		Assert.notNull(user, "User may not be null.");
		return this.iUserDAO.save(user);
	}
	
	public List<Routine> getRoutines(Long id){
		Optional<Model> oModel = iUserDAO.findById(id);
		List<Routine> routines = new ArrayList<Routine>();
		if (oModel.isPresent()) {
			Model user = oModel.get();
			routines = user.getRoutines();
		}
		return routines;
	}
	
	
	
	 
	
	
	
}
