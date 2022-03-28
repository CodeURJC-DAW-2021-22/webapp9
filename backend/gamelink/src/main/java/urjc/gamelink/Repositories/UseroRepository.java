package urjc.gamelink.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import urjc.gamelink.Model.Usero;


public interface UseroRepository extends JpaRepository<Usero, Long> {
    Optional<Usero> findByName(String name);

    @Query(
        value = "SELECT v.genre, COUNT(*) FROM tbl_videogame_users u, tbl_videogame v WHERE u.purchase_videogames_id = v.id GROUP BY v.genre",
        nativeQuery = true)
    List<Object> findByGenre();

    @Query(
        value = "SELECT v.title, COUNT(*) FROM public.tbl_videogame_users u, public.tbl_videogame v WHERE u.purchase_videogames_id = v.id GROUP BY v.title",
        nativeQuery = true
    )
    List<Object> findBySold();
}

