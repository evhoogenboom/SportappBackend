package backend.dao;

import org.springframework.data.repository.CrudRepository;

import backend.model.Tag;

public interface ITagDAO extends CrudRepository<Tag, Long> {

}
