package pe.edu.unsch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unsch.dao.SemestreDao;
import pe.edu.unsch.entities.Semestreacademico;

@Service("semestreService")
@Transactional
public class SemestreServiceImpl implements SemestreService {
	
	@Autowired
	private SemestreDao semestreDao;
		
	public List<Semestreacademico> getSemestres(){
		return semestreDao.getSemestres();
	}
		

}
