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
import backend.model.Tag;

@Transactional
@Service
public class RoutineService implements IRoutineService {

	@Autowired
	private IRoutineDAO iRoutineDAO;
	
	@Autowired
	private IService iUserService;
	
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
	public List<Tag> getTags(Long id){
		Optional<Routine> oRoutine = iRoutineDAO.findById(id);
		List<Tag> tags = new ArrayList<Tag>();
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			tags = routine.getTags();
		}
		return tags;
	}
	
	@Override 
	public void deleteRoutine(Long id) {
		Optional<Routine> oRoutine = iRoutineDAO.findById(id);
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			this.iRoutineDAO.delete(routine);
		}
	}
	
	@Override
	public Iterable<Routine> findWithTag(String tagName) {
		ArrayList<Routine> routinesWithTag = new ArrayList<Routine>();
		Iterable<Routine> routines = findAll();
		ROUTINELOOP: for (Routine routine: routines) {
			System.out.println(routine);
			Iterable<Tag> tags = routine.getTags();
			//Iterable<Tag> tags = getTags(routine.getId());
			for (Tag tag: tags) {
				if (tagName.equals(tag.getName())) {
					routinesWithTag.add(routine);
					continue ROUTINELOOP;
				}
			}
		}
		return routinesWithTag;
	}
	
	
	public Iterable<Routine> findAllButUser(Long id) {
		Iterable<Routine> all = findAll();
		Iterable<Routine> allFromUser = iUserService.getRoutines(id);
		List<Routine> allButUser = (List<Routine>) findAll();
		for (Routine userRoutine : allFromUser) {
			for (Routine routine : all) {
				if (routine.getName().equals(userRoutine.getName())) {
					allButUser.remove(routine);
				}
			}
		}
		return allButUser;
	}
	
	 
}
