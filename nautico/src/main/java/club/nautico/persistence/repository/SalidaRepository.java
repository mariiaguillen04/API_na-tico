package club.nautico.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Salida;
import club.nautico.service.dto.SalidaDto;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Integer >{

	SalidaDto convertToDto(Salida salida);
	Salida convertToEntity(SalidaDto salidaDto);
}
