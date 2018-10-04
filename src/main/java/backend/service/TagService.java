package backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import backend.dao.ITagDAO;
import backend.model.Tag;

@Service
public class TagService implements ITagService {

	@Autowired
	private ITagDAO iTagDAO;
	
	@Override
	public Tag create(Tag tag) {
		Assert.notNull(tag, "Tag may not be null.");
		return this.iTagDAO.save(tag);
	}
	
	@Override
	public Optional<Tag> findById(Long id) {
		return this.iTagDAO.findById(id);
	}
	
	
	
}
 