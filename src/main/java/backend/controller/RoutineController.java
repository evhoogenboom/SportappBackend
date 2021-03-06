package backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Routine;
import backend.model.Routine_Exercise_specifications;
import backend.model.Tag;
import backend.service.IRoutineService;
import backend.service.ISpecificationsService;
import backend.service.ITagService;
import dto.SpecificationDTO;
import dto.TagDTO;

@RestController
public class RoutineController {
	
	@Autowired
	private IRoutineService iRoutineService;
	
	@Autowired
	private ISpecificationsService iSpecificationsService;
	
	@Autowired
	private ITagService iTagService; 
	
	@GetMapping("api/routine/all")
	public Iterable<Routine> findAll(){
		return this.iRoutineService.findAll();
	}
	
	@GetMapping("api/routine/findallbutuser/{id}")
	public Iterable<Routine> findAllButUser(@PathVariable Long id) {
		return this.iRoutineService.findAllButUser(id);
	}
	
	@GetMapping("api/routine/findwithtag/{tagName}")
	public Iterable<Routine> findWithTag(@PathVariable String tagName){
		System.out.println("tagfunctie aangeroepen");
		return this.iRoutineService.findWithTag(tagName);
	}
	
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
	
	@GetMapping("api/routine/{id}/tags")
	public List<Tag> getTags(@PathVariable Long id){
		return this.iRoutineService.getTags(id);
	}
	
	@PostMapping("api/routine/new")
	public Routine create(@RequestBody Routine routine) {
		return this.iRoutineService.create(routine);
	} 
	 
	@DeleteMapping("api/routine/delete/{id}")
	public Long deleteRoutine(@PathVariable Long id) {
		System.out.println("deleted routine"+id);
		this.iRoutineService.deleteRoutine(id);
		return id;
		
	}
	
	@PutMapping("/api/routine/{id}/addSpecification")
	public SpecificationDTO addSpecification(@PathVariable Long id, @RequestBody SpecificationDTO DTO) {  
		Optional<Routine> oRoutine = iRoutineService.findById(id);
		Routine_Exercise_specifications specification = new Routine_Exercise_specifications();
		
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			// set specification
			specification.setName(DTO.getName());
			specification.setRepetitions(DTO.getRepetitions());
			specification.setExercise(DTO.getExercise());
			// add specification to database
			this.iSpecificationsService.create(specification);
			// add specification to routine
			List<Routine_Exercise_specifications> specifications = routine.getSpecifications();
			specifications.add(specification);
			routine.setSpecifications(specifications);
			// update DTO
			DTO.setId(specification.getId());
			// update routine in database 
			this.iRoutineService.create(routine);
		}
		return DTO;
	}
	
	@PutMapping("/api/routine/{id}/changeName")
	public String changeName(@PathVariable Long id, @RequestBody String name) {
		Optional<Routine> oRoutine = iRoutineService.findById(id);
		if(oRoutine.isPresent()) {
			Routine routine = oRoutine.get();
			routine.setName(name);
			this.iRoutineService.create(routine);
		}
		return name;
	}
	
	@PutMapping("/api/routine/{routineId}/addTag")
	public TagDTO addTag(@PathVariable Long routineId, @RequestBody TagDTO dto) {  
		Optional<Routine> oRoutine = iRoutineService.findById(routineId);
		Tag tag = new Tag();
		
		if (oRoutine.isPresent()) {
			Routine routine = oRoutine.get();  
			// set tag
			tag.setName(dto.getName());
			// add tag to database
			this.iTagService.create(tag);
			// add tag to routine
			List<Tag> tags = routine.getTags();
			tags.add(tag);
			routine.setTags(tags);
			// update DTO
			dto.setId(tag.getId());
			// update routine in database 
			this.iRoutineService.create(routine);
		}
		return dto;
	}

}
