package ar.edu.unlam.instituto.persona;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.instituto.cursos.Curso;

public class Alumno extends Persona {

	private Set<Curso> cursosAprobados;
	private Map<LocalDate,Boolean>asistencia;

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
		super(dni, nombre, apellido, fechaDeNacimiento);
		this.cursosAprobados=new HashSet<Curso>();
		this.asistencia=new HashMap<LocalDate,Boolean>();
	}
	public Map<LocalDate, Boolean> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Map<LocalDate, Boolean> asistencia) {
		this.asistencia = asistencia;
	}
	public Set<Curso> getCursosAprobados() {
		return cursosAprobados;
	}
	public void setCursosAprobados(HashSet<Curso> cursosAprobados) {
		this.cursosAprobados = cursosAprobados;
	}

	public Boolean registrarAsistencia(LocalDate fecha, Boolean presente) {
		Boolean asistenciaRegistrada=false;		
		if(asistencia.get(fecha)==null) {
			asistencia.put(fecha,presente);
			asistenciaRegistrada=true;	
		}	
		
		return asistenciaRegistrada;
	}
	

	

	    public Boolean registrarAsistencia1(LocalDate fecha, Boolean presente) {
	        Boolean asistenciaRegistrada = false;
	        
	       
	        if (asistencia.get(fecha) == null) {
	            asistencia.put(fecha, presente);
	            asistenciaRegistrada = true;  
	        }
	        
	        return asistenciaRegistrada;
	    
	    }


	

}
