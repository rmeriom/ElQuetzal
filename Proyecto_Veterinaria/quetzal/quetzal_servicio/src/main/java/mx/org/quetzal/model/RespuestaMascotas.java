package mx.org.quetzal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.org.quetzal.modelo.Mascota;
import mx.org.quetzal.modelo.Visitas;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaMascotas {
	
	private List<Mascota> listMAscota;
	private List<Visitas> listVisita; 
	

	
}
