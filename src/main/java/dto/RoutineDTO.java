package dto;

import java.util.List;

import backend.model.Routine_Exercise_specifications;

public class RoutineDTO {
	
	private Long id;
	
	private List<Routine_Exercise_specifications> specifications;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Routine_Exercise_specifications> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<Routine_Exercise_specifications> specifications) {
		this.specifications = specifications;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
