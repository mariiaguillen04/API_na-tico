package club.nautico.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Barco;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Integer >{


}
