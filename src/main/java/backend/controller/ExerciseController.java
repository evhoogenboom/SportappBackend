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
import backend.service.IExerciseService;
import dto.ExerciseDTO;

@RestController
public class ExerciseController {

	@Autowired
	private IExerciseService iExerciseService;

	@GetMapping("/api/exercise")
	public Iterable<Exercise> findAll(){
		return this.iExerciseService.findAll();
	}
	
	@GetMapping("/api/exercise/{name}")
	public List<Exercise> findByName(@PathVariable String name){
		return this.iExerciseService.findByName(name);
	}
	
	/*
	 *  We returnen een DTO ipv een exercise,
	 *  omdat dit handiger is voor bidirectional mapping.
	 *  Momenteel gebruiken we enkel unidirectional mapping.
	 */
	@PostMapping("/api/exercise/new")
	public ExerciseDTO create(@RequestBody Exercise exercise) {
		this.iExerciseService.create(exercise);
		ExerciseDTO exerciseDTO = new ExerciseDTO();
		exerciseDTO.setId(exercise.getId());
		exerciseDTO.setName(exercise.getName());
		return exerciseDTO;
	}
	
	//modify overschrijft alle velden behalve 'id'
	@PutMapping("/api/exercise/{id}/modify")
	public ExerciseDTO modify(@PathVariable Long id, @RequestBody ExerciseDTO DTO) {  
		Optional<Exercise> oExercise = iExerciseService.findById(id);
		if (oExercise.isPresent()) {
			Exercise exercise = oExercise.get();
			exercise.setName(DTO.getName());
			exercise.setDescription(DTO.getDescription());
			this.iExerciseService.create(exercise);
		}
		return DTO;
	}
}
