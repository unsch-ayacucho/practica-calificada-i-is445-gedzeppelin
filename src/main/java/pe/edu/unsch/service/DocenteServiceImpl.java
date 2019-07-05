package pe.edu.unsch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unsch.dao.DocenteDao;
import pe.edu.unsch.entities.Docente;

@Service("docenteService")
@Transactional
public class DocenteServiceImpl implements DocenteService{
	
	@Autowired
	private DocenteDao docenteDao;
	
	@Override
	public Docente getDocente(long l) {
		return docenteDao.getDocente(l);
	}

	@Override
	public List<Docente> getDocentes() {
		return docenteDao.getDocentes();
	}
	
}


