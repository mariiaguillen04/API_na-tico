package club.nautico.persistence.entity;




import javax.print.attribute.standard.DateTimeAtCompleted;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Salida {
	
	//Atributos	
	
	@Id
	@GeneratedValue
	private int idSalida;
	private int idBarco;
	private int idUser;
	private String destino;
	private DateTimeAtCompleted fechaHora;

}
