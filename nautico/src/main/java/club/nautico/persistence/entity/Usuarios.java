package club.nautico.persistence.entity;

import javax.print.attribute.standard.DateTimeAtCompleted;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Usuarios {

	//Atributos Tabla Usuario
	@Id
	@GeneratedValue
	private Long id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private String direccion;
	private String email;
	private String num_socio;
	private String num_patron;
	
	
}
