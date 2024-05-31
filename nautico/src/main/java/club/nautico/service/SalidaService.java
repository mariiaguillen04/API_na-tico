package club.nautico.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.nautico.persistence.entity.Salida;
import club.nautico.persistence.repository.SalidaRepository;
import club.nautico.service.dto.SalidaDto;

@Service
public class SalidaService {
	
	@Autowired
	private SalidaRepository salidaRepositorio;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	public SalidaDto convertToDto(Salida salida) {
		return modelMapper.map(salida, SalidaDto.class);
	}
	
	public Salida convertToEntity(SalidaDto salidaDto) {
		return modelMapper.map(salidaDto, Salida.class);
	}
	
	
	
	public SalidaDto createSalida(SalidaDto salidaDto) {
		Salida salida = convertToEntity(salidaDto);
		Salida salidaC= salidaRepositorio.save(salida);
		return convertToDto(salidaC);
	}
	
	public SalidaDto updateSalida(SalidaDto salidaDto) {
		
		Optional<Salida> salida = salidaRepositorio.findById(salidaDto.getId());
		Salida salidaU;
	
		if(salida.isPresent()) {
			
			salida = Optional.ofNullable(convertToEntity(salidaDto));
			
			salidaU = salidaRepositorio.save(salida.get());
			return convertToDto(salidaU);
			
		}else {
			//excepción que hay que crear
	
		}
		
		
	}
	
	
	public void deleteSalidaById(SalidaDto salidaDto, int id) {
		Salida salida = convertToEntity(salidaDto);
		
		salidaRepositorio.deleteById(id);
		
	}
	
	
	/*public List<Salida> findAllSalidas(){
		return List<Salida> ;
	}*/
	

}
