package urjc.gamelink.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import urjc.gamelink.Model.News;

public interface NewRepository extends JpaRepository<News, Long> {

    Page<News> findAll(Pageable pageable);

}