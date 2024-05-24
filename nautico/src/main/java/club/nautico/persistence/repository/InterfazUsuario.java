package club.nautico.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import club.nautico.persistence.entity.Usuario;

public interface InterfazUsuario extends CrudRepository<Usuario, Long> {

}
