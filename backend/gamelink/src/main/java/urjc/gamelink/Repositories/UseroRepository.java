package urjc.gamelink.Repositories;

import java.util.List;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import urjc.gamelink.Configuration.resultGraphic;
import urjc.gamelink.Model.Usero;


public interface UseroRepository extends JpaRepository<Usero, Long> {
    Optional<Usero> findByName(String name);

    /*@Query()
    List<Usero> findSimilarUsers(Usero user);*/
    @Query(
        value = "SELECT v.genre, COUNT(*) FROM tbl_user_purchase_videogames u, tbl_videogame v WHERE u.purchase_videogames_id = v.id GROUP BY v.genre;",
        nativeQuery = true)
    List<Object> findByGenre();

}

