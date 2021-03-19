package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.CatRaza;
import mx.org.quetzal.repository.ICatRazaRepository;
import mx.org.quetzal.service.IRazaService;

@Service
public class RazaServiceImpl implements IRazaService {
	
	@Autowired
	private ICatRazaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<CatRaza> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public CatRaza findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CatRaza save(CatRaza entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public CatRaza update(CatRaza entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<CatRaza> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
