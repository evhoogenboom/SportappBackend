package backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Routine_Exercise_specifications;
import backend.service.IRoutineService;
import backend.service.ISpecificationsService;

@RestController
public class SpecificationsController {
	
	@Autowired
	private ISpecificationsService iSpecificationsService;
	
	@Autowired 
	private IRoutineService iRoutineService;
	
	@PostMapping("api/specifications/new")
	public Routine_Exercise_specifications create(@RequestBody Routine_Exercise_specifications specifications) {
		return this.iSpecificationsService.create(specifications);
	}
	
	@GetMapping("api/specifications/{id}")
	public Optional<Routine_Exercise_specifications> findById(@PathVariable Long id) {
		return this.iSpecificationsService.findById(id);
	}
	
	/*
	 * get, put, post, delete
	@PutMapping("api/specifications/add")
	public ExerciseDTO addExercise(@RequestBody ExerciseDTO exerciseDTO) {
		
		Optional<Routine> oRoutine = this.iRoutineService.findById(exerciseDTO.getSpecificationsID());
		
		Routine_Exercise_specifications specifications = new Routine_Exercise_specifications();
		
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			exercise.setName(exerciseDTO.getName());
			exercise.setRepetitions(exerciseDTO.getRepetitions());
			exercise.setRoutine(routine);
		} 
		this.iExerciseService.create(exercise);
		
		exerciseDTO.setId(exercise.getId());
		return exerciseDTO;
	}*/
}
