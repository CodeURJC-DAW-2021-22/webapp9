package urjc.gamelink.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import urjc.gamelink.Model.Videogame;

public interface VideogameRepository extends JpaRepository<Videogame, Long> {

}
