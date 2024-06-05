package club.nautico.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.nautico.persistence.entity.Salida;
import club.nautico.persistence.repository.SalidaRepository;
import club.nautico.service.dto.SalidaDto;

@Service
public class SalidaService {

	@Autowired
	private SalidaRepository salidaRepositorio;

	private final ModelMapper MODELMAPPER = new ModelMapper();

	public SalidaDto convertToDto(Salida salida) {
		return MODELMAPPER.map(salida, SalidaDto.class);
	}

	public Salida convertToEntity(SalidaDto salidaDto) {
		return MODELMAPPER.map(salidaDto, Salida.class);
	}

	public SalidaDto createSalida(SalidaDto salidaDto) {
		// Guardamos ell DTO en una variable entidad
		Salida salida = convertToEntity(salidaDto);
		// Modificamos la tabla y almacenamos la nueva tabla
		Salida salidaC = salidaRepositorio.save(salida);
		// Devolvemos el DTO de la nueva salida
		return salidaRepositorio.convertToDto(salidaC);
	}

	public SalidaDto updateSalida(SalidaDto salidaDto, int id) {

		// Busca la salida por ID, si no la encuentra, se lanza una excepción
		Salida salidaUpdate = this.salidaRepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Salida not found with id " + id));

		// Copia las propiedades del DTO de salida al modelo de salida
		BeanUtils.copyProperties(salidaDto, salidaUpdate);

		// Guarda el modelo de salida actualizado en la base de datos
		Salida updatedSalida = this.salidaRepositorio.save(salidaUpdate);

		// Convierte la salida actualizada a DTO
		return convertToDto(updatedSalida);
	}

	public boolean deleteSalidaById(SalidaDto salidaDto, int id) {
		boolean salidaDelete = false;

		if (this.salidaRepositorio.findById(salidaDto.getId()).isPresent()) {
			salidaRepositorio.deleteById(id);
			salidaDelete = true;
		} else {
			// excepción
		}
		return salidaDelete;

	}

	public List<Salida> findAllSalida() {
		return this.salidaRepositorio.findAll();
	}

}
