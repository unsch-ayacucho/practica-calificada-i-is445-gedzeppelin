package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.entities.Docente;

public interface DocenteDao {
	
	public Docente getDocente(long l);
	
	public List<Docente> getDocentes();

}
