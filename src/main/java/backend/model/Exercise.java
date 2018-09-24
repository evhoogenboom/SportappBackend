package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Routine routine;
	
	@Column
	private String name;
	
	private String description;
	
	private int repetitions;
	
	//private image?? image;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Routine getRoutine() {
		return routine;
	}
	
	public void setRoutine(Routine routine) {
		this.routine = routine;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getRepetitions() {
		return repetitions;
	}
	
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
	
}
