package mx.org.quetzal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodigoPostal {
	
	 private String d_codigo;
	  private String c_tipo_asenta;
	  private String d_tipo_asenta;
	  private String d_asenta;
	  private String c_mnpio;
	  private String d_mnpio;
	  private Float c_estado;
	  private String d_estado;
	  private Float c_cve_ciudad;
	  private String d_ciudad;

}
