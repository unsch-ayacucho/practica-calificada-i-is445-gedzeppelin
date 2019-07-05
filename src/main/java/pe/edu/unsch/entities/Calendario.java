package pe.edu.unsch.entities;
// Generated 05/07/2019 03:19:52 PM by Hibernate Tools 4.3.2-SNAPSHOT


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Calendario generated by hbm2java
 */
@Entity
@Table(name="calendario"
    ,catalog="cargabd"
)
public class Calendario  implements java.io.Serializable {


     private Long idcalendario;
     private int horastotales;
     private int horasteoria;
     private int horaspractica;
     private int horaslaboratorio;
     private Set<Semestreacademico> semestreacademicos = new HashSet<Semestreacademico>(0);
     private Set<Docente> docentes = new HashSet<Docente>(0);

    public Calendario() {
    }

	
    public Calendario(int horastotales, int horasteoria, int horaspractica, int horaslaboratorio) {
        this.horastotales = horastotales;
        this.horasteoria = horasteoria;
        this.horaspractica = horaspractica;
        this.horaslaboratorio = horaslaboratorio;
    }
    public Calendario(int horastotales, int horasteoria, int horaspractica, int horaslaboratorio, Set<Semestreacademico> semestreacademicos, Set<Docente> docentes) {
       this.horastotales = horastotales;
       this.horasteoria = horasteoria;
       this.horaspractica = horaspractica;
       this.horaslaboratorio = horaslaboratorio;
       this.semestreacademicos = semestreacademicos;
       this.docentes = docentes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcalendario", unique=true, nullable=false)
    public Long getIdcalendario() {
        return this.idcalendario;
    }
    
    public void setIdcalendario(Long idcalendario) {
        this.idcalendario = idcalendario;
    }

    
    @Column(name="horastotales", nullable=false)
    public int getHorastotales() {
        return this.horastotales;
    }
    
    public void setHorastotales(int horastotales) {
        this.horastotales = horastotales;
    }

    
    @Column(name="horasteoria", nullable=false)
    public int getHorasteoria() {
        return this.horasteoria;
    }
    
    public void setHorasteoria(int horasteoria) {
        this.horasteoria = horasteoria;
    }

    
    @Column(name="horaspractica", nullable=false)
    public int getHoraspractica() {
        return this.horaspractica;
    }
    
    public void setHoraspractica(int horaspractica) {
        this.horaspractica = horaspractica;
    }

    
    @Column(name="horaslaboratorio", nullable=false)
    public int getHoraslaboratorio() {
        return this.horaslaboratorio;
    }
    
    public void setHoraslaboratorio(int horaslaboratorio) {
        this.horaslaboratorio = horaslaboratorio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="calendario")
    public Set<Semestreacademico> getSemestreacademicos() {
        return this.semestreacademicos;
    }
    
    public void setSemestreacademicos(Set<Semestreacademico> semestreacademicos) {
        this.semestreacademicos = semestreacademicos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="calendario")
    public Set<Docente> getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }




}


