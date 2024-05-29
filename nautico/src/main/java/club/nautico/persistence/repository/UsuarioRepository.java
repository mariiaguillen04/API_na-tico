package club.nautico.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Usuario;

@Repository

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
