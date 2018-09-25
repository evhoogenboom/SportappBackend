package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Exercise;
import backend.service.IExerciseService;
import dto.ExerciseDTO;

@RestController
public class ExerciseController {

	@Autowired
	private IExerciseService iExerciseService;

	@GetMapping("exercise")
	public Iterable<Exercise> findAll(){
		return this.iExerciseService.findAll();
	}
	
	@GetMapping("/api/exercise/{name}")
	public List<Exercise> findByName(@PathVariable String name){
		return this.iExerciseService.findByName(name);
	}
	
	@PostMapping("/api/exercise/new")
	public ExerciseDTO create(@RequestBody Exercise exercise) {
		this.iExerciseService.create(exercise);
		ExerciseDTO exerciseDTO = new ExerciseDTO();
		exerciseDTO.setId(exercise.getId());
		return exerciseDTO;
	}
	
}
