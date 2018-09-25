package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.service.IService;
import backend.model.Model;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private IService iService;
	
	@GetMapping("/api/login/{name}")
	public List<Model> findByUsername(@PathVariable String name) {
		System.out.println("in check");
		return this.iService.findByUsername(name);
	}
	
	@PostMapping("/api/user")
	public Model create(@RequestBody Model user) {
		return this.iService.create(user);
	} 
	
	
	
	
	
}
  