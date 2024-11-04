package ar.edu.unlam.instituto.cursos;

import java.util.Objects;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.persona.Alumno;

public abstract class Curso implements Comparable <Curso>{
	
	private String codigoCurso;
	private Integer cicloLectivo;
	private Nivel nivel;

	public Curso(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		this.codigoCurso=codigoCurso;
		this.cicloLectivo=cicloLectivo;
		this.nivel=nivel;
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
	
	public abstract void asignarCursoParaAlumno(Alumno alumno)throws EdadAlumnoFueraDeRangoException;

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
