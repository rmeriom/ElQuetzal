package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.Visitas;
import mx.org.quetzal.repository.IVisitaRepository;
import mx.org.quetzal.service.IVisitaService;

@Service
public class VisitaServiceImpl implements IVisitaService {
	
	@Autowired
	private IVisitaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Visitas> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public Visitas findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Visitas save(Visitas entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public Visitas update(Visitas entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<Visitas> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
