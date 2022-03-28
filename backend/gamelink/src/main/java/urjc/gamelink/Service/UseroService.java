package urjc.gamelink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urjc.gamelink.Model.Usero;
import urjc.gamelink.Repositories.UseroRepository;

@Service
public class UseroService {
	@Autowired
	private UseroRepository repository;

	public Optional<Usero> findById(long id) {
		return repository.findById(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Usero> findAll() {
		return repository.findAll();
	}

	public void save(Usero u) {
		repository.save(u);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

    public List<Object> findByGenre() {
        return repository.findByGenre();
    }

    public List<Object> findBySold() {
        return repository.findBySold();
    }

    public Optional<Usero> findByName(String name) {
        return repository.findByName(name);
    }
}

