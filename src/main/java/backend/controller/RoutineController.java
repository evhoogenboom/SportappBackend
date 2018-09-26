package backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Routine;
import backend.model.Routine_Exercise_specifications;
import backend.service.IRoutineService;

@RestController
public class RoutineController {
	
	@Autowired
	private IRoutineService iRoutineService;
	
	@GetMapping("api/routine/{name}")
	public List<Routine> findByName(@PathVariable String name){
		return this.iRoutineService.findByName(name);
	}
	
	@GetMapping("api/routine/{id}")
	public Optional<Routine> findById(@PathVariable Long id){
		return this.iRoutineService.findById(id);
	}
	
	@GetMapping("api/routine/{id}/specifications")
	public List<Routine_Exercise_specifications> getSpecifications(@PathVariable Long id){
		return this.iRoutineService.getSpecifications(id);
	}
	
	@PostMapping("api/routine/new")
	public Routine create(@RequestBody Routine routine) {
		return this.iRoutineService.create(routine);
	}
	
	@DeleteMapping("api/routine/delete/{id}")
	public void deleteRoutine(@PathVariable Long id) {
		this.iRoutineService.deleteRoutine(id);
	}
	
}
