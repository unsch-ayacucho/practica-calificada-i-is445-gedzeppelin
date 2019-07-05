package pe.edu.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.entities.Semestreacademico;

@Repository("calendarioDao")
public class SemestreDaoImpl implements SemestreDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Semestreacademico> getSemestres() {
		return (List<Semestreacademico>) entityManager
		.createQuery("select s from Semestreacademico s", Semestreacademico.class)
		.getResultList();
	}

	
}
