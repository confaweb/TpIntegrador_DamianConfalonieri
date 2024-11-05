package ar.edu.unlam.instituto.cursos;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.CantidadDocentesInsuficienteException;
import ar.edu.unlam.instituto.exceptions.DocenteSinExperienciaAcreditadaException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Secundaria;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Docente;
import ar.edu.unlam.instituto.persona.Persona;

public class Division  extends Curso implements Secundaria {

	public Division(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		super(codigoCurso, cicloLectivo, nivel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void asignarCursoParaAlumno(Alumno alumno) throws EdadAlumnoFueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona buscarAlumnoPorDni(Integer dni) throws AlumnoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean verificarCantidadDocentesACargo() throws CantidadDocentesInsuficienteException {
		Boolean docentesVerificados=false;
		if(this.getDocestesACargo().isEmpty())
			throw new CantidadDocentesInsuficienteException(getCodigoCurso());
		else
		return docentesVerificados;
	}

	@Override
	public Boolean asignarDocentesACargo(Docente docente) throws DocenteSinExperienciaAcreditadaException {
		// TODO Auto-generated method stub
		return null;
	}

}
