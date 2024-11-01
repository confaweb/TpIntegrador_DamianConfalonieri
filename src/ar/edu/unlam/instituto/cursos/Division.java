package ar.edu.unlam.instituto.cursos;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.interfaces.Secundaria;

public class Division  extends Curso implements Secundaria {

	public Division(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		super(codigoCurso, cicloLectivo, nivel);
		// TODO Auto-generated constructor stub
	}

}
