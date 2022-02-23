package urjc.gamelink.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import urjc.gamelink.Model.News;

public interface NewRepository extends JpaRepository<News, Long> {

}