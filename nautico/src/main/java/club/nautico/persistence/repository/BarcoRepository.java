package club.nautico.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import club.nautico.persistence.entity.Barco;
import club.nautico.service.dto.BarcoDto;

@Repository
public interface BarcoRepository extends JpaRepository<BarcoDto, Integer >{
	List<BarcoDto> findAllBarcosDto(BarcoDto barcoDto);

	Barco save(Barco barco);

}
