package ar.edu.unlam.instituto.cursos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.CantidadDocentesInsuficienteException;
import ar.edu.unlam.instituto.exceptions.DocenteSinExperienciaAcreditadaException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Docente;
import ar.edu.unlam.instituto.persona.Persona;

public abstract class Curso implements Comparable <Curso>{
	
	private String codigoCurso;
	private Integer cicloLectivo;
	private Nivel nivel;
	Set<Alumno> listaAlumnosPorCurso;
	private Set <Docente> docestesACargo;

	public Curso(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		this.codigoCurso=codigoCurso;
		this.cicloLectivo=cicloLectivo;
		this.nivel=nivel;
		this.setDocestesACargo(new HashSet<Docente>());
		this.listaAlumnosPorCurso=new TreeSet <Alumno>();
	}

	/**
	 * @return the codigoCurso
	 */
	public String getCodigoCurso() {
		return codigoCurso;
	}

	/**
	 * @param codigoCurso the codigoCurso to set
	 */
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	/**
	 * @return the cicloLectivo
	 */
	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	/**
	 * @param cicloLectivo the cicloLectivo to set
	 */
	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	/**
	 * @return the nivel
	 */
	public Nivel getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public Set <Docente> getDocestesACargo() {
		return docestesACargo;
	}

	public void setDocestesACargo(Set <Docente> docestesACargo) {
		this.docestesACargo = docestesACargo;
	}

	/**
	 * @return the listaAlumnosPorCurso
	 */
	public Set<Alumno> getListaAlumnosPorCurso() {
		return listaAlumnosPorCurso;
	}

	/**
	 * @param listaAlumnosPorCurso the listaAlumnosPorCurso to set
	 */
	public void setListaAlumnosPorCurso(Set<Alumno> listaAlumnosPorCurso) {
		this.listaAlumnosPorCurso = listaAlumnosPorCurso;
	}

	public abstract void asignarCursoParaAlumno(Alumno alumno)throws EdadAlumnoFueraDeRangoException;
	public abstract Persona buscarAlumnoPorDni(Integer dni)throws AlumnoInexistenteException;
	public abstract Boolean verificarCantidadDocentesACargo()throws CantidadDocentesInsuficienteException;
	public abstract Boolean asignarDocentesACargo(Docente docente)throws DocenteSinExperienciaAcreditadaException;

	@Override
	public int compareTo(Curso o) {
		// TODO Auto-generated method stub
		return this.codigoCurso.compareTo(o.getCodigoCurso());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigoCurso, other.codigoCurso);
	}

	
}
