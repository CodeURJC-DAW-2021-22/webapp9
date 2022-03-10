package urjc.gamelink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import urjc.gamelink.Model.Usero;
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

	public void save(Videogame vg) {
		repository.save(vg);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

    public List<Videogame> findByIds(List<Long> relatedGame) {
        return repository.findAllById(relatedGame);
    }

    public Page<Videogame> findAll(PageRequest of) {
        return repository.findAll(of);
    }

	public List<Object> findByFavouriteGenre(Usero user) {
        return repository.findByFavouriteGenre(user);
    }
}
