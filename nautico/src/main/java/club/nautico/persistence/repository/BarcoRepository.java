package club.nautico.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Barco;
import club.nautico.persistence.entity.Salida;

@Repository
public interface BarcoRepository extends JpaRepository<Salida, Integer >{

}
