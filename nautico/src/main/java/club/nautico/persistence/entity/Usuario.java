package club.nautico.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data

public class Usuario {

	//Atributos Tabla Usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private String direccion;
	private String email;
	
	//Relacion 1:N con tabla barco (para identificar el dueño del barco según num_socio)
		@OneToMany(mappedBy = "usuario", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
//		@Pattern(regexep = "[a-Z]{3}[0-9]{3}")
		private List<Barco> barco;
		
		//Relacion 1:N con tabla salida (para identificar el patrón necesario para sacar el barco)
		@OneToMany(mappedBy = "usuario", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
//		@Pattern(regexep = "[a-Z]{3}[0-9]{4}")
		private List<Salida> salida;
		
	
}
