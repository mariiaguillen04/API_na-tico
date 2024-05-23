package club.nautico.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class Salida {
	
	//Atributos	
	
	@Id
	@GeneratedValue
	private int idSalida;
	private int idBarco;
	private int idUser;

}
