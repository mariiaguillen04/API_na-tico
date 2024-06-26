package club.nautico.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.nautico.persistence.entity.Barco;
import club.nautico.persistence.repository.BarcoRepository;
import club.nautico.service.dto.BarcoDto;


@Service
public class BarcoService {
	
	@Autowired
	private BarcoRepository barcoRepositorio;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	public BarcoDto convertToDto(Barco barco) {
		return modelMapper.map(barco, BarcoDto.class);
	}
	
	public Barco convertToEntity(BarcoDto barcoDto) {
		return modelMapper.map(barcoDto, Barco.class);
	}
	
	public BarcoDto createBarco(BarcoDto barcoDto) {
		Barco barco = convertToEntity(barcoDto);
		Barco barcoSave = barcoRepositorio.save(barco);
		return convertToDto(barcoSave);
	}
	
	public BarcoDto updateSalida (BarcoDto barcoDto) {
		Barco barco = convertToEntity(barcoDto);
		barco = barcoRepositorio.findById(((Object) barco).getIdBarco());
		BarcoDto barcoU = barcoRepositorio.save(((Optional<BarcoDto>) barco).get());
		return barcoU;
		
	}
		
	public void deleteBarcoById(BarcoDto barcoDto, int id) { 
		Barco barco = convertToEntity (barcoDto);
		barcoRepositorio.deleteById(id);
	}
	
	public List<BarcoDto> findAllBarcosDto(BarcoDto barcoDto){
		List<BarcoDto> barcos = barcoRepositorio.findAll();
       
		return barcos;
	}

}
