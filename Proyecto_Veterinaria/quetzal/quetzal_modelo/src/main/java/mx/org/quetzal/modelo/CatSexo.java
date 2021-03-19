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
@Table(name = "cat_sex")
public class CatSexo {

	@Id
	@Column(name = "id_sex", updatable = false, nullable = false, length = 19, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sex_sequence")
	@SequenceGenerator(name = "sex_sequence", sequenceName = "sex_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "descripcion", length = 50)
	private String descripcion;
	
}
