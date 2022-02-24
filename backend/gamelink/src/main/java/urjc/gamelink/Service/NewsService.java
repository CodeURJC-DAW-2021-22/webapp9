package urjc.gamelink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urjc.gamelink.Model.News;
import urjc.gamelink.Repositories.NewRepository;

@Service
public class NewsService {
    
	@Autowired
	private NewRepository repository;

	public Optional<News> findById(long id) {
		return repository.findById(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<News> findAll() {
		return repository.findAll();
	}

	public void save(News book) {
		repository.save(book);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}