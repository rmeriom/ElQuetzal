package mx.org.quetzal.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<T> {
	
	public List<T> findAll(Boolean borrado) throws SQLException, Exception;

	public List<T> findAll() throws SQLException, Exception;

	public T findById(Long id) throws SQLException, Exception;

	public T save(T entity) throws SQLException, Exception;

	public T update(T entity) throws SQLException, Exception;

	public void deteleById(Long id) throws SQLException, Exception;

}
