package mx.org.quetzal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaEncuesta {
	
	private String descripcion;
	private String opcion;
	
	private Long idPregunta;
	

}
