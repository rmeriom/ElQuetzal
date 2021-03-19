package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.CatColor;
import mx.org.quetzal.repository.ICatColorRepository;
import mx.org.quetzal.service.IColorService;

@Service
public class ColorServiceImpl implements IColorService {
	
	@Autowired
	private ICatColorRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<CatColor> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public CatColor findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CatColor save(CatColor entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public CatColor update(CatColor entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<CatColor> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
