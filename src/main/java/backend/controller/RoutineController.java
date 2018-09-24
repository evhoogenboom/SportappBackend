package backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Routine;
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
	
	@PostMapping("api/routine/new")
	public Routine create(@RequestBody Routine routine) {
		return this.iRoutineService.create(routine);
	}
	
}
