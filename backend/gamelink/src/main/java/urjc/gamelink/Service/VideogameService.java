package urjc.gamelink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public Page<Videogame> findRecomended(long id, Pageable pageable) {
        return repository.findRecomended(id,pageable);
    }

	public List<Videogame> findRecomended2(long id) {
        return repository.findRecomended2(id);
    }
}

