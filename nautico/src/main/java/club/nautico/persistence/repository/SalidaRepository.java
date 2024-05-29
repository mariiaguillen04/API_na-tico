package club.nautico.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Salida;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Integer >{

}
