package club.nautico.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data

public class Barco {
	
	
		//Atributos Tabla Barco
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idBarco;
		private String matricula;
		private String nombre;
		private Long nAmarre;
		private double cuota;
		
		@ManyToOne
		private Usuario usuario;


		// Relación n:1 con tabla salida
		@OneToMany(mappedBy = "barco", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
		private List<Salida> salida;
		
		
	

}
