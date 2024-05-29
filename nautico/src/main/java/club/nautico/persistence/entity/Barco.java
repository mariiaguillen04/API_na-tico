package club.nautico.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Barco<Salida> {
	
	
		//Atributos Tabla Barco
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idBarco;
		private String matricula;
		private String nombre;
		private Long nAmarre;
		private double cuota;
		
		@ManyToOne
		private List<Usuario> usuario;


		// Relación n:1 con tabla salida
		@ManyToOne
		private List<Salida> salida;
		
		
	

}
