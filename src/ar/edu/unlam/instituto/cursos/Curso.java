package ar.edu.unlam.instituto.cursos;

import ar.edu.unlam.instituto.enums.Nivel;

public abstract class Curso {
	
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
}
