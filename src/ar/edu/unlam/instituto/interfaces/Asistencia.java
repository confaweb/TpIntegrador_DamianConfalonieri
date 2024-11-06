package ar.edu.unlam.instituto.interfaces;

import java.time.LocalDate;

import ar.edu.unlam.instituto.cursos.Curso;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;

public interface Asistencia {
	Boolean asistirAClase(Curso curso, LocalDate fecha) throws AlumnoInexistenteException;

	Boolean faltarAClase(Curso curso, LocalDate fecha) throws AlumnoInexistenteException;

	Double calcularPorcentajeAsistencia();
}
