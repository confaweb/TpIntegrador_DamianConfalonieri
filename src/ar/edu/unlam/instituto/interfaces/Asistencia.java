package ar.edu.unlam.instituto.interfaces;

import java.time.LocalDate;

import ar.edu.unlam.instituto.cursos.Curso;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.FechaRepetidaException;

public interface Asistencia {
	Boolean asistirAClase(Curso curso, LocalDate fecha) throws AlumnoInexistenteException, FechaRepetidaException;

	Boolean faltarAClase(Curso curso, LocalDate fecha) throws AlumnoInexistenteException;

	Double calcularPorcentajeAsistencia();
}
