package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.CatSexo;

@Repository
public interface ICatSexoRepository extends CrudRepository<CatSexo, Long> {
	
	public List<CatSexo> findAll(Sort by);

}
