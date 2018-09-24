package backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Exercise;
import backend.model.Routine;
import backend.service.IExerciseService;
import backend.service.IRoutineService;
import dto.ExerciseDTO;

@RestController
public class ExerciseController {

	@Autowired
	private IExerciseService iExerciseService;
	@Autowired
	private IRoutineService iRoutineService;
	
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
	
	@PutMapping("api/exercise/add")
	public ExerciseDTO addExercise(@RequestBody ExerciseDTO exerciseDTO) {
		//find routine
		Optional<Routine> oRoutine = this.iRoutineService.findById(exerciseDTO.getRoutineID());
		//make new exercise
		Exercise exercise = new Exercise();
		//set routine to exercise
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			exercise.setName(exerciseDTO.getName());
			exercise.setRepetitions(exerciseDTO.getRepetitions());
			exercise.setRoutine(routine);
		} 
		this.iExerciseService.create(exercise);
		
		exerciseDTO.setId(exercise.getId());
		return exerciseDTO;
	}
	
}
