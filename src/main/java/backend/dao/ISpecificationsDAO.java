package backend.dao;

import org.springframework.data.repository.CrudRepository;

import backend.model.Routine_Exercise_specifications;

public interface ISpecificationsDAO extends CrudRepository<Routine_Exercise_specifications, Long>{}
