package urjc.gamelink.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import urjc.gamelink.Model.Usero;


public interface UseroRepository extends JpaRepository<Usero, Long> {
    Optional<Usero> findByName(String name);
}

