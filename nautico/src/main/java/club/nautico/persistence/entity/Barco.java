package club.nautico.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
		
<<<<<<< HEAD
		@ManyToOne
		private Usuario usuario;

		
=======
		// Relación n:1 con tabla salida
		@ManyToOne()
		@JoinColumn(name = "salida_id")
		private int idSalida;
		
		// Relación 1:n con tabla usuarios
		@OneToMany(mappedBy = "usuario", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
		private List<Usuarios> usuario;
		private int idUsuario;
>>>>>>> branch 'master' of https://github.com/mariiaguillen04/API_na-tico.git
		

}
