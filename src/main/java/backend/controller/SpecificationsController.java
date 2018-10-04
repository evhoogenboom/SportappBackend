package backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Routine_Exercise_specifications;
import backend.service.ISpecificationsService;

@RestController
public class SpecificationsController {
	
	@Autowired
	private ISpecificationsService iSpecificationsService;
		
	@PostMapping("api/specifications/new")
	public Routine_Exercise_specifications create(@RequestBody Routine_Exercise_specifications specifications) {
		return this.iSpecificationsService.create(specifications);
	}
	
	@GetMapping("api/specifications/{id}")
	public Optional<Routine_Exercise_specifications> findById(@PathVariable Long id) {
		return this.iSpecificationsService.findById(id);
	}
	
	@DeleteMapping("api/specifications/delete/{id}")
	public Long delete(@PathVariable Long id) {
		System.out.println("deleted specification "+ id);
		this.iSpecificationsService.delete(id);
		return id;
	}
	
	//@GetMapping("api/specification/{id}/getExercise")
	
	
}
