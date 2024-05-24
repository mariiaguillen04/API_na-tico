package club.nautico.persistence.entity;




import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data

public class Salida {
	
	//Atributos	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String destino;
	private DateTimeAtCompleted fechaEntrada;
	private DateTimeAtCompleted fechaSalida;

	
	// cascade = jakarta.persistence.CascadeType.ALL --> para que cualquier modificación relaionada se ejecute en todo lo relacionado
	// orphanRemoval = true --> cuando elimine algo, se elimine todo lo relacionado
	// Relación 1:n con tabla barco
	@ManyToOne
	private Usuario usuario;
	
	
	
}
