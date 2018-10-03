package backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import backend.dao.IRoutineDAO;
import backend.model.Routine;
import backend.model.Routine_Exercise_specifications;

@Transactional
@Service
public class RoutineService implements IRoutineService {

	@Autowired
	private IRoutineDAO iRoutineDAO;
	
	@Override
	public Iterable<Routine> findAll(){
		return this.iRoutineDAO.findAll();
	}
	
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
	
	@Override
	public List<Routine_Exercise_specifications> getSpecifications(Long id){
		Optional<Routine> oRoutine = iRoutineDAO.findById(id);
		List<Routine_Exercise_specifications> specifications = new ArrayList<Routine_Exercise_specifications>();
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			specifications = routine.getSpecifications();
		}
		return specifications;
	}
	
	@Override 
	public void deleteRoutine(Long id) {
		Optional<Routine> oRoutine = iRoutineDAO.findById(id);
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			this.iRoutineDAO.delete(routine);
		}
	}
	
}
