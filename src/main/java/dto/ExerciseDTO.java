package dto;

public class ExerciseDTO {
	
	private Long id;
	
	private String name;
	
	private int repetitions;
	
	private Long routineID;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public Long getRoutineID() {
		return routineID;
	}

	public void setRoutineID(Long routineID) {
		this.routineID = routineID;
	}
	
	
}
