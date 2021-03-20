package mx.org.quetzal.service;

import java.sql.SQLException;
import java.util.List;

import mx.org.quetzal.modelo.CatUsuario;

public interface IUsuarioService extends IGenericService<CatUsuario> {

	List<CatUsuario> findByNombre(String etiqueta) throws SQLException, Exception;
	


}
