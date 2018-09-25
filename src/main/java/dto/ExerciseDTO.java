package dto;

public class ExerciseDTO {
	
	private Long id;
	
	private String name;
	
	private Long specificationsID;

	
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

	public Long getSpecificationsID() {
		return specificationsID;
	}

	public void setSpecificationsID(Long specificationsID) {
		this.specificationsID = specificationsID;
	}


}
