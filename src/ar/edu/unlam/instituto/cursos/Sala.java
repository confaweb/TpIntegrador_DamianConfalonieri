package ar.edu.unlam.instituto.cursos;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.interfaces.Jardin;

public class Sala extends Curso implements Jardin {

	public Sala(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		super(codigoCurso,cicloLectivo,nivel);
	}

}
