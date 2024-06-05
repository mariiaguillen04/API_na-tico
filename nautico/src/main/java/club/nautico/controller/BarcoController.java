package club.nautico.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import club.nautico.exception.ResourceNotFoundException;
import club.nautico.persistence.entity.Barco;
import club.nautico.persistence.repository.BarcoRepository;
import club.nautico.service.dto.BarcoDto;

@RestController
@RequestMapping("/api/v1/Barcos")
public class BarcoController {
	
	@Autowired
	private BarcoRepository BarcoRepository;
	
	@GetMapping
	//Listar todos los barcos
	public List<BarcoDto> getAllBarcos() {
		return BarcoRepository.findAll();
	}
	
	@PostMapping
	//Crear barco
	public Barco createBarco(@RequestBody Barco Barco) {
		return BarcoRepository.save(Barco);
	}
	
	@GetMapping("{id}")
	//Buscar Barco por id 
	public ResponseEntity<BarcoDto> getBarcoById(@PathVariable int id){
		BarcoDto Barco = BarcoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El barco con id: "+ id+" no existe."));
	return ResponseEntity.ok(Barco);
	}
	
	@PutMapping("{id}")
	//Modificar barco 
	public ResponseEntity<BarcoDto> updateUsuario(int id, Barco BarcoDetails) {
		BarcoDto updateBarco = BarcoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El barco con id: "+ id+" no existe."));
		updateBarco.setNombre(BarcoDetails.getNombre()); //BarcoDetails es nuestro "DTO"
		updateBarco.setCuota(BarcoDetails.getCuota());
		//Se podría ampliar el update
		BarcoRepository.save(updateBarco);
		return ResponseEntity.ok(updateBarco);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteBarco(@PathVariable int id) {
		BarcoDto Barco = BarcoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El barco con id: "+ id+" no existe."));
	BarcoRepository.delete(Barco);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
