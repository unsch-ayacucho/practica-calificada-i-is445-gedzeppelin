package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.entities.Docente;

	public interface DocenteService {
	
		public Docente getDocente(long l);
		
		public List<Docente> getDocentes();

}
