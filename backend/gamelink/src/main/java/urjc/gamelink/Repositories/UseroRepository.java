package urjc.gamelink.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import urjc.gamelink.Model.Usero;


public interface UseroRepository extends JpaRepository<Usero, Long> {
    Optional<Usero> findByName(String name);

    /*@Query()
    List<Usero> findSimilarUsers(Usero user);*/
}

