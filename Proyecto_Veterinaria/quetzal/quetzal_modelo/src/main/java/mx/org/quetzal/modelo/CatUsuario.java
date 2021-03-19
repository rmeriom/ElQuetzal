package mx.org.quetzal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cat_usuario")
public class CatUsuario {

	@Id
	@Column(name = "id_usuario", updatable = false, nullable = false, length = 19, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "nombre", length = 30)
	private String nombre;
	
	@Column(name = "ap_paterno", length = 50)
	private String apPaterno;
	
	@Column(name = "ap_materno", length = 30)
	private String apMaterno;
	
}
