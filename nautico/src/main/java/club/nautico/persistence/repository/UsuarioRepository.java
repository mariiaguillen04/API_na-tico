package club.nautico.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import club.nautico.models.UserModel;

@Repository

public interface UsuarioRepository extends JpaRepository<UserModel, Long> {

}
