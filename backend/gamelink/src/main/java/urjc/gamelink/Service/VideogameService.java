package urjc.gamelink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urjc.gamelink.Model.Videogame;
import urjc.gamelink.Repositories.VideogameRepository;

@Service
public class VideogameService {
    
	@Autowired
	private VideogameRepository repository;

	public Optional<Videogame> findById(long id) {
		return repository.findById(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Videogame> findAll() {
		return repository.findAll();
	}

	public void save(Videogame book) {
		repository.save(book);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
