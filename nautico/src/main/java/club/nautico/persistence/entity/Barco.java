package club.nautico.persistence.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
		
		

}
