package club.nautico.controller;
 
	import java.util.List;
 
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
import club.nautico.persistence.entity.Usuario;
import club.nautico.persistence.repository.UsuarioRepository;
 
	@RestController
	@RequestMapping("/api/v1/Usuarios")
	public class UsuarioController {
 
		@Autowired
		private UsuarioRepository UsuarioRepository;
		
		@GetMapping
		//Listar todos los usuarios
		public List<Usuario> getAllUsuarios() {
			return UsuarioRepository.findAll();
		}
		
		@PostMapping
		//Crear usuario
		public Usuario createUsuario(@RequestBody Usuario Usuario) {
			return UsuarioRepository.save(Usuario);
		}
		
		@GetMapping("{id}")
		//Buscar Usuario por id (se podria hacer por dni *PENDIENTE*)
		public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id){
			Usuario Usuario = UsuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: "+ id));
		return ResponseEntity.ok(Usuario);
		}
		
		@PutMapping("{id}")
		//Modificar usuario (podriamos utilizar el dni)
		public ResponseEntity<Usuario> updateUsuario(long id, Usuario UsuarioDetails) {
			Usuario updateUsuario = UsuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: "+ id));
			updateUsuario.setNombre(UsuarioDetails.getNombre()); //UsuarioDetails es nuestro "DTO"
			updateUsuario.setEmail(UsuarioDetails.getEmail());
			//Se podría ampliar el update
			UsuarioRepository.save(updateUsuario);
			return ResponseEntity.ok(updateUsuario);
		}
		
		@DeleteMapping("{id}")
		public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable long id) {
			Usuario Usuario = UsuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: "+ id));
		UsuarioRepository.delete(Usuario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}