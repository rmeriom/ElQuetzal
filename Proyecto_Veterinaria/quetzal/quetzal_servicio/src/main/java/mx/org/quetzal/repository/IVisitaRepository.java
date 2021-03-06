package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.Visitas;

@Repository
public interface IVisitaRepository extends CrudRepository<Visitas, Long> {
	
	public List<Visitas> findAll(Sort by);
	
}
