package mx.org.quetzal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultGrafica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private List<String> etiquetaConsecion;
	private List<String> seriesAnios;
	private List<List<Integer>> datosCantidad;
	
	
	public void addEtiqueta (String etiqueta) {
		if (this.etiquetaConsecion == null) {
			this.etiquetaConsecion = new ArrayList<>();
		}
		
		this.etiquetaConsecion.add(etiqueta);
	}
	
	public void addSerieAnios (String anio) {
		if (this.seriesAnios == null) {
			this.seriesAnios = new ArrayList<>();
		}
		this.seriesAnios.add(anio);
	}
	
	public void addDatoCantidad (int index , int value) {
		if (this.datosCantidad == null) {
			this.datosCantidad = new ArrayList<List<Integer>>();
		}

	
		for (int i = this.datosCantidad.size(); i <= index; i++) {
				this.datosCantidad.add(new ArrayList<Integer>());
		}
		
	
		this.datosCantidad.get(index).add(value);
		
	}


}
