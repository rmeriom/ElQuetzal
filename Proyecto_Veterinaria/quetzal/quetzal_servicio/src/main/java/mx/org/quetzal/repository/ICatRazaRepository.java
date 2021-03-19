package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.CatRaza;

@Repository
public interface ICatRazaRepository extends CrudRepository<CatRaza, Long> {
	
	public List<CatRaza> findAll(Sort by);

}
