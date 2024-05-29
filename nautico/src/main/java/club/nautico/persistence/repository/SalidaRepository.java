package club.nautico.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Salida;

@Repository
public interface SalidaRepository extends CrudRepository<Salida, Integer >{

}
