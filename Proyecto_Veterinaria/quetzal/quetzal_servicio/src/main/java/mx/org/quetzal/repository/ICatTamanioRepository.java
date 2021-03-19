package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.CatTamanio;

@Repository
public interface ICatTamanioRepository extends CrudRepository<CatTamanio, Long> {
	
	public List<CatTamanio> findAll(Sort by);

}
