package urjc.gamelink.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import urjc.gamelink.Model.Usero;
import urjc.gamelink.Model.Videogame;

public interface VideogameRepository extends JpaRepository<Videogame, Long> {

    @Query(value = "SELECT DISTINCT v.* FROM tbl_user_purchase_videogames u, tbl_videogame v WHERE v.id NOT IN (SELECT DISTINCT u.purchase_videogames_id FROM tbl_user_purchase_videogames u WHERE u.tbl_user_id = :id) AND v.id IN ((SELECT v.id FROM tbl_videogame v WHERE v.genre IN (SELECT sub.genre FROM (SELECT v.genre, COUNT(*) FROM tbl_user_purchase_videogames u, tbl_videogame v WHERE u.purchase_videogames_id = v.id GROUP BY v.genre ORDER BY 2 DESC LIMIT 3) AS sub)))",
        nativeQuery = true)
    Page<Videogame> findRecomended(@Param("id") long id, Pageable pageable);
    
}
