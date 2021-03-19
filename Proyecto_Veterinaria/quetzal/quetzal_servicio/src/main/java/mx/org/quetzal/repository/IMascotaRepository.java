package mx.org.quetzal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.org.quetzal.modelo.Mascota;

@Repository
public interface IMascotaRepository extends CrudRepository<Mascota, Long> {
	
	public List<Mascota> findAll(Sort by);

}
