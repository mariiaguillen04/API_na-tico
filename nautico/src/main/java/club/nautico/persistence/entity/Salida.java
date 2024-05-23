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

public class Salida {
	
	//Atributos	
	
	@Id
	@GeneratedValue
	private int id;
	private int idBarco;
	private int idUser;
	private String destino;
	private DateTimeAtCompleted fechaEntrada;
	private DateTimeAtCompleted fechaSalida;

}
