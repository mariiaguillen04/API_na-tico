package club.nautico.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.nautico.persistence.entity.Salida;
import club.nautico.persistence.repository.SalidaRepository;
import club.nautico.persistence.repository.UsuarioRepository;
import club.nautico.service.dto.SalidaDto;

@Service
public class SalidaService {

	@Autowired
	private SalidaRepository salidaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	private final ModelMapper MODELMAPPER = new ModelMapper();

	public SalidaDto convertToDto(Salida salida) {
		return MODELMAPPER.map(salida, SalidaDto.class);
	}
	
	

	public Salida convertToEntity(SalidaDto salidaDto) {
		return MODELMAPPER.map(salidaDto, Salida.class);
	}
	
	
//Métodos básicos
	
	public SalidaDto createSalida(SalidaDto salidaDto) {
		// Guardamos el DTO en una variable entidad
		Salida salida = convertToEntity(salidaDto);
		// Modificamos la tabla y almacenamos la nueva tabla
		Salida salidaC = salidaRepository.save(salida);
		// Devolvemos el DTO de la nueva salida
		return salidaRepository.convertToDto(salidaC);
	}

	
	
	public SalidaDto updateSalida(SalidaDto salidaDto, int id) {

		// Busca la salida por ID, si no la encuentra, se lanza una excepción
		Salida salidaUpdate = this.salidaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Salida not found with id " + id));

		// Copia las propiedades del DTO de salida al modelo de salida
		BeanUtils.copyProperties(salidaDto, salidaUpdate);

		// Guarda el modelo de salida actualizado en la base de datos
		Salida updatedSalida = this.salidaRepository.save(salidaUpdate);

		// Convierte la salida actualizada a DTO
		return convertToDto(updatedSalida);
	}
	
	

	public boolean deleteSalidaById(SalidaDto salidaDto, int id) {
		boolean salidaDelete = false;

		if (this.salidaRepository.findById(salidaDto.getId()).isPresent()) {
			salidaRepository.deleteById(id);
			salidaDelete = true;
		} else {
			// excepción
		}
		return salidaDelete;

	}
	
	
	public Optional<Salida> getSalidaById(int id) {
		
				if(this.salidaRepository.findById(id) != null) {
					return salidaRepository.findById(id);
				} else {
					//Excepción
					return null;
				}
	}
	
	/*public Optional<Salida> getSalidaByPatron(){
		
	}
	*/

	public List<Salida> findAllSalida() {
		return this.salidaRepository.findAll();
	}

}
