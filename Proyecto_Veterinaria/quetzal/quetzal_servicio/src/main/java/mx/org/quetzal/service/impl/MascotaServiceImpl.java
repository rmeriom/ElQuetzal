package mx.org.quetzal.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.org.quetzal.modelo.Mascota;
import mx.org.quetzal.repository.IMascotaRepository;
import mx.org.quetzal.service.IMascotaService;

@Service
public class MascotaServiceImpl implements IMascotaService {
	
	@Autowired
	private IMascotaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Mascota> findAll() throws SQLException, Exception {
		return  repository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional(readOnly = true)
	public Mascota findById(Long id) throws SQLException, Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Mascota save(Mascota entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public Mascota update(Mascota entity) throws SQLException, Exception {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deteleById(Long id) throws SQLException, Exception {
		repository.deleteById(id);
	}

	@Override
	public List<Mascota> findAll(Boolean borrado) throws SQLException, Exception {
		return findAll(borrado);
	}


}
