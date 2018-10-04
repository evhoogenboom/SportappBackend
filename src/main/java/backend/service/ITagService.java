package backend.service;

import java.util.Optional;

import backend.model.Tag;

public interface ITagService {
	
	public Tag create(Tag tag);
	
	public Optional<Tag> findById(Long id);
}
