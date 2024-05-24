package club.nautico.persistence.entity;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Usuarios {

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
	@OneToMany(mappedBy = "num_socio", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	@Pattern(regexep = "[a-Z]{3}[0-9]{3}")
	private String num_socio;
	//Relacion 1:N con tabla salida (para identificar el patrón necesario para sacar el barco)
	@OneToMany(mappedBy = "num_patron", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	@Pattern(regexep = "[a-Z]{3}[0-9]{4}")
	private String num_patron;
	
	
}
