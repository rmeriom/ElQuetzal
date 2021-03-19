package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.CatSintomas;
import mx.org.quetzal.repository.ICatSintomasRepository;
import mx.org.quetzal.service.ISintomasService;

@Service
public class SintomasServiceImpl implements ISintomasService {
	
	@Autowired
	private ICatSintomasRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<CatSintomas> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public CatSintomas findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CatSintomas save(CatSintomas entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public CatSintomas update(CatSintomas entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<CatSintomas> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
