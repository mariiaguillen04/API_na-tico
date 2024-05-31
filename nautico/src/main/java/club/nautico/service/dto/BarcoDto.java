package club.nautico.service.dto;

import lombok.Data;

@Data

public class BarcoDto {

	private int id;
	private String matricula;
	private String nombre;
	private Long nAmarre;
	private double cuota;
	
}
