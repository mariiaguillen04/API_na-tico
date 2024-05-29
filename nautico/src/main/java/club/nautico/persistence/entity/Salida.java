package club.nautico.persistence.entity;




import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.annotations.CascadeType;
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

public class Salida {
	
	//Atributos	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// cascade = jakarta.persistence.CascadeType.ALL --> para que cualquier modificación relaionada se ejecute en todo lo relacionado
	// orphanRemoval = true --> cuando elimine algo, se elimine todo lo relacionado
	// Relación 1:n con tabla barco
	@OneToMany(mappedBy = "salida", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	private List<Barco> barco;
	private int idBarco;
	
	// Relación 1:n con tabla usuario
	@OneToMany(mappedBy = "salida", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	private List<Usuarios> usuario;
	private Long idUser;
	
	private String destino;
	private DateTimeAtCompleted fechaEntrada;
	private DateTimeAtCompleted fechaSalida;

}
