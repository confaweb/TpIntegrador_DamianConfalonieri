/**
 * 
 */
package ar.edu.unlam.instituto.cursos;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Primaria;
import ar.edu.unlam.instituto.persona.Alumno;

/**
 * 
 */
public class Grado extends Curso implements Primaria {

	/**
	 * 
	 */
	public Grado(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		super(codigoCurso, cicloLectivo, nivel);
	}

	@Override
	public void asignarCursoParaAlumno(Alumno alumno) throws EdadAlumnoFueraDeRangoException {
		
		
	}

}
