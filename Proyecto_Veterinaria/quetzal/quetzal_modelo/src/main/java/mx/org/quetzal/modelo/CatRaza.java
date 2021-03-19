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
@Table(name = "cat_raza")
public class CatRaza {

	@Id
	@Column(name = "id_raza", updatable = false, nullable = false, length = 19, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "raza_sequence")
	@SequenceGenerator(name = "raza_sequence", sequenceName = "raza_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "descripcion", length = 50)
	private String descripcion;
	
}
