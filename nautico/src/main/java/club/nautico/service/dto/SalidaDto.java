package club.nautico.service.dto;

import javax.print.attribute.standard.DateTimeAtCompleted;

import lombok.Data;

@Data

public class SalidaDto {
	private int id;
	private String destino;
	private DateTimeAtCompleted fechaEntrada;
	private DateTimeAtCompleted fechaSalida;

}
