package pe.edu.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.entities.Docente;

@Repository("docenteDao")
public class DocenteDaoImpl implements DocenteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Docente getDocente(long l) {
		return (Docente) entityManager.find(Docente.class, l);
	}

	@Override
	public List<Docente> getDocentes() {
		return (List<Docente>) entityManager
		.createQuery("select d from Docente d", Docente.class)
		.getResultList();
	}

	
}
