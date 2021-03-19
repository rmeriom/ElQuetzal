package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.CatSintomas;

@Repository
public interface ICatSintomasRepository extends CrudRepository<CatSintomas, Long> {
	
	public List<CatSintomas> findAll(Sort by);

}
