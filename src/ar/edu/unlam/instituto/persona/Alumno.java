package ar.edu.unlam.instituto.persona;

import java.time.LocalDate;
import java.util.HashSet;

import ar.edu.unlam.instituto.cursos.Curso;

public class Alumno extends Persona {

	private HashSet<Curso> cursosAprobados;

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
		super(dni, nombre, apellido, fechaDeNacimiento);
		this.setCursosAprobados(new HashSet<Curso>());
	}

	/**
	 * @return the cursosAprobados
	 */
	public HashSet<Curso> getCursosAprobados() {
		return cursosAprobados;
	}

	/**
	 * @param cursosAprobados the cursosAprobados to set
	 */
	public void setCursosAprobados(HashSet<Curso> cursosAprobados) {
		this.cursosAprobados = cursosAprobados;
	}

}
