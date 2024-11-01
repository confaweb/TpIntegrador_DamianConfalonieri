/**
 * 
 */
package ar.edu.unlam.instituto.cursos;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.interfaces.Primaria;

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

}
