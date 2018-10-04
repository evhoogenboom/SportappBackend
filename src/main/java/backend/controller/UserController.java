package backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Model;
import backend.model.Routine;
import backend.service.IRoutineService;
import backend.service.IService;
import dto.RoutineDTO;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private IService iService;
	
	@Autowired 
	private IRoutineService iRoutineService;
	
	@GetMapping("/api/login/{name}")
	public List<Model> findByUsername(@PathVariable String name) {
		System.out.println("in check");
		return this.iService.findByUsername(name);
	}
	
	@PostMapping("/api/user")
	public Model create(@RequestBody Model user) {
		return this.iService.create(user);
	} 
	
	@GetMapping("api/user/{id}/routines")
	public List<Routine> getRoutines(@PathVariable Long id){
		return this.iService.getRoutines(id);
	}
	
	@PutMapping("/api/user/{id}/addRoutine")
	public RoutineDTO addRoutine(@PathVariable Long id, @RequestBody RoutineDTO DTO) {  
		Optional<Model> oUser = iService.findById(id);
		Routine routine = new Routine();
		
		if (oUser.isPresent()) {
			Model user = oUser.get();
			// set specification
			routine.setName(DTO.getName());
			// add specification to database
			this.iRoutineService.create(routine);
			// add specification to routine
			List<Routine> routines = user.getRoutines();
			routines.add(routine);
			user.setRoutines(routines);
			// update DTO
			DTO.setId(routine.getId());
			// update routine in database 
			this.iRoutineService.create(routine);
		}
		return DTO;
	}
	
	
	
}
  