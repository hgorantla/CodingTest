package com.java.assignment.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.assignment.bean.Unicorn;
import com.java.assignment.repository.Repository;

@Service
public class UnicornServiceImpl{
	
	@Autowired
	Repository repo;
	
	public Integer createUnicorn(Unicorn unicorn) {
		unicorn  = repo.save(unicorn);
		return unicorn.getUnicornId();
	}

	public Unicorn UpdateUnicorn(Unicorn unicorn, Integer id) throws Exception {
		Optional<Unicorn> existing  = getById(id);
		if(existing.isPresent()) {
			unicorn.setUnicornId(id);
			unicorn  = repo.save(unicorn);
			return unicorn;
		} else {
			throw new Exception("Invalid id. No data found for the given id.");
		}
		
		
		
	}

	public List<Unicorn> getAll() {
		return (List<Unicorn>) repo.findAll();
	}
	
	public Optional<Unicorn> getById(Integer id) {
		return repo.findById(id);
	}
}
