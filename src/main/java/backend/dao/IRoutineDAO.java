package backend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import backend.model.Routine;

public interface IRoutineDAO extends CrudRepository<Routine, Long>{

	public List<Routine> findByName(String name);
	
}
