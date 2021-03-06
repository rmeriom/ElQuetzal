package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.CatUsuario;
import mx.org.quetzal.repository.ICatUsuarioRepository;
import mx.org.quetzal.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private ICatUsuarioRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<CatUsuario> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public CatUsuario findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CatUsuario save(CatUsuario entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public CatUsuario update(CatUsuario entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<CatUsuario> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}

	
	@Override
	public List<CatUsuario> findByNombre(String etiqueta) throws SQLException, Exception {
		
		return repository.findByNombre(etiqueta);
	}


}
