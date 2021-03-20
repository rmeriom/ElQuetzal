package mx.org.quetzal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mascota")
public class Mascota {

	@Id
	@Column(name = "id_mascota", updatable = false, nullable = false, length = 19, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascota_sequence")
	@SequenceGenerator(name = "mascota_sequence", sequenceName = "mascota_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "nombre", length = 30)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_raza")
	private CatRaza catRaza;
	
	@ManyToOne
	@JoinColumn(name = "id_color")
	private CatColor catColor;
	
	@ManyToOne
	@JoinColumn(name = "id_tamanio")
	private CatTamanio catTamanio;
	
	@ManyToOne
	@JoinColumn(name = "id_sex")
	private CatSexo catSexo;
	
	@Column(name = "edad")
	private Long edad;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private CatUsuario catUsuario;



}
