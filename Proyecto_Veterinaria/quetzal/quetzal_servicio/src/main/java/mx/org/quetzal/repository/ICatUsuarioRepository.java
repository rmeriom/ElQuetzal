package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.CatUsuario;

@Repository
public interface ICatUsuarioRepository extends CrudRepository<CatUsuario, Long> {
	
	public List<CatUsuario> findAll(Sort by);

}
