package urjc.gamelink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


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

	
	public Page<News> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<News> findAll() {
		return repository.findAll();
	}

	public void save(News n) {
		repository.save(n);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public Page<News> findAll(PageRequest of) {
		return repository.findAll(of);
	}
    public List<News> findByIds(List<Long> notices) {
        return repository.findAllById(notices);
    }

}
