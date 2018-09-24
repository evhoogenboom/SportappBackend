package backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import backend.dao.IRoutineDAO;
import backend.model.Routine;

@Service
public class RoutineService implements IRoutineService {

	@Autowired
	private IRoutineDAO iRoutineDAO;
	
	@Override
	public List<Routine> findByName(String name){
		return this.iRoutineDAO.findByName(name);
	}
	
	@Override
	public Routine create(Routine routine) {
		Assert.notNull(routine, "Routine may not be null.");
		return this.iRoutineDAO.save(routine);
	}
	
	@Override
	public Optional<Routine> findById(Long id){
		return this.iRoutineDAO.findById(id);
	}
}
