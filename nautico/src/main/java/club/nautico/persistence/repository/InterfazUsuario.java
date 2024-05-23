package club.nautico.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import club.nautico.persistence.entity.Usuarios;

public interface InterfazUsuario extends CrudRepository<Usuarios, Long> {

}
