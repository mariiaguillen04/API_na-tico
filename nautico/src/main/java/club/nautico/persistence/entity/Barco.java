package club.nautico.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data

public class Barco {
	
	
		//Atributos Tabla Barco
		@Id
		@GeneratedValue
		private Long idBarco;
		private String matricula;
		private String nombre;
		private Long nAmarre;
		private double cuota;
		
		@ManyToOne
		private Usuario usuario;

		
		

}
