package club.nautico.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Barco;

@Repository
public interface BarcoRepository extends CrudRepository<Barco, Integer >{

}
