package backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import backend.dao.ISpecificationsDAO;
import backend.model.Routine_Exercise_specifications;

@Service
public class SpecificationsService implements ISpecificationsService{

	@Autowired
	private ISpecificationsDAO iSpecificationsDAO;
	
	@Override
	public Routine_Exercise_specifications create(Routine_Exercise_specifications specifications) {
		Assert.notNull(specifications, "Specifictions may not be null.");
		return this.iSpecificationsDAO.save(specifications);
	}
	
	@Override
	public Optional<Routine_Exercise_specifications> findById(Long id) {
		return this.iSpecificationsDAO.findById(id);
	}
	
	@Override
	public void delete(Long id) {
		this.iSpecificationsDAO.deleteById(id);
	}
	
}
