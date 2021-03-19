package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.CatTamanio;
import mx.org.quetzal.repository.ICatTamanioRepository;
import mx.org.quetzal.service.ITamanioService;

@Service
public class TamanioServiceImpl implements ITamanioService {
	
	@Autowired
	private ICatTamanioRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<CatTamanio> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public CatTamanio findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CatTamanio save(CatTamanio entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public CatTamanio update(CatTamanio entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<CatTamanio> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
