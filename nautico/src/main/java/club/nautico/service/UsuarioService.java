package club.nautico.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.nautico.service.dto.UsuarioDto;
import club.nautico.models.UserModel;
import club.nautico.persistence.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository userRepository; // Inyección de instancia del repositorio de UserRepository para interactuar con la base de datos

	private final ModelMapper modelMapper = new ModelMapper();
	
	public ArrayList<UserModel> getUsers() {
		// Retorna una lista de todos los usuarios almacenados en la base de datos
		return (ArrayList<UserModel>) userRepository.findAll();
	}

	public UsuarioDto saveUser(UsuarioDto userDTO) {
		//Convertimos el DTO a entidad para que interactue con la base de datos.
		UserModel user = modelMapper.map(userDTO, UserModel.class);
		//Guardamos la entidad en la base de datos.
		UserModel usuarioGuardado = userRepository.save(user);
		//Convertimos la entidad a DTO para devolver la respuesta
		UsuarioDto usuarioGuardadoDTO = modelMapper.map(usuarioGuardado, UsuarioDto.class);
		
		return usuarioGuardadoDTO;
	}

	public Optional<UsuarioDto> getUserById(Long id) {
		// Busca un usuario por ID en la base de datos
		Optional<UserModel> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			// Si el usuario existe, convierte la entidad a DTO usando modelMapper
			UsuarioDto userDTO = modelMapper.map(userOptional.get(), UsuarioDto.class);
			// Devuelve un Optional que contiene el DTO de usuario
			return Optional.of(userDTO);
		} else {
			// Si el usuario no existe, devuelve un Optional vacío
			return Optional.empty();
		}
	}

	public Optional<UsuarioDto> UpdateUserById(UsuarioDto userDTO, Long id) {
		// Buscamos el usuario por ID
		Optional<UserModel> userOptional = userRepository.findById(id);
		// Comprobamos si el usuario existe
		if (userOptional.isPresent()) {
			//Si existe el usuario, actualizamos los campos con los valores que tiene el DTO.
			UserModel user = userOptional.get();
			modelMapper.map(userDTO, user);
			//Guardamos los cambios en la base de datos
			UserModel updateUser = userRepository.save(user);
			//Convertimos la entidad actualizada a DTO
			UsuarioDto updateUserDTO = modelMapper.map(updateUser, UsuarioDto.class);
			//Devolvemos el usuario actualizado en formato DTO
			return Optional.of(updateUserDTO);
		} else {
			return Optional.empty();
		}
	}

	public Boolean deleteUser(Long id) {
		try {
			//Verificamos si el usuario existe
			Optional<UserModel> userOptional = userRepository.findById(id);
			if (userOptional.isPresent()) {
				userRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// Retorna false si ocurre un error al eliminar el usuario
			return false;
		}
	}
}
