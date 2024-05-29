package club.nautico.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Salida;
import club.nautico.persistence.entity.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Salida, Integer > {

}
