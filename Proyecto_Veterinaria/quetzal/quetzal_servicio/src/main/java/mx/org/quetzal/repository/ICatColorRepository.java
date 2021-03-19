package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.CatColor;

@Repository
public interface ICatColorRepository extends CrudRepository<CatColor, Long> {
	
	public List<CatColor> findAll(Sort by);

}
