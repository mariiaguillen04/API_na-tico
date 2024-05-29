package club.nautico.persistence.entity;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.List;

import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;
import javax.print.attribute.standard.DateTimeAtCompleted;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Component

@Entity
@Data

public class Salida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String destino;
	private DateTimeAtCompleted fechaEntrada;
	private DateTimeAtCompleted fechaSalida;

	
	@ManyToOne
	private List<Barco> barco;



	@ManyToOne
	private List<Usuario> usuario;

}