package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.CatSexo;
import mx.org.quetzal.repository.ICatSexoRepository;
import mx.org.quetzal.service.ISexoService;

@Service
public class SexoServiceImpl implements ISexoService {
	
	@Autowired
	private ICatSexoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<CatSexo> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public CatSexo findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CatSexo save(CatSexo entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public CatSexo update(CatSexo entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<CatSexo> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
