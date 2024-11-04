package ar.edu.unlam.instituto.cursos;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Jardin;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Persona;

public class Sala extends Curso implements Jardin {

	Set<Alumno> listaAlumnosSalaVerde;
	Set<Alumno> listaAlumnosSalaAzul;
	Set<Alumno> listaAlumnosSalaRoja;

	public Sala(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		super(codigoCurso, cicloLectivo, nivel);
		this.listaAlumnosSalaVerde = new TreeSet<Alumno>();
		this.listaAlumnosSalaAzul = new TreeSet<Alumno>();
		this.listaAlumnosSalaRoja = new TreeSet<Alumno>();
	}

	/**
	 * @return the listaAlumnosSalaVerde
	 */
	public Set<Alumno> getListaAlumnosSalaVerde() {
		return listaAlumnosSalaVerde;
	}

	/**
	 * @param listaAlumnosSalaVerde the listaAlumnosSalaVerde to set
	 */
	public void setListaAlumnosSalaVerde(Set<Alumno> listaAlumnosSalaVerde) {
		this.listaAlumnosSalaVerde = listaAlumnosSalaVerde;
	}

	/**
	 * @return the listaAlumnosSalaAzul
	 */
	public Set<Alumno> getListaAlumnosSalaAzul() {
		return listaAlumnosSalaAzul;
	}

	/**
	 * @param listaAlumnosSalaAzul the listaAlumnosSalaAzul to set
	 */
	public void setListaAlumnosSalaAzul(Set<Alumno> listaAlumnosSalaAzul) {
		this.listaAlumnosSalaAzul = listaAlumnosSalaAzul;
	}

	/**
	 * @return the listaAlumnosSalaRoja
	 */
	public Set<Alumno> getListaAlumnosSalaRoja() {
		return listaAlumnosSalaRoja;
	}

	/**
	 * @param listaAlumnosSalaRoja the listaAlumnosSalaRoja to set
	 */
	public void setListaAlumnosSalaRoja(Set<Alumno> listaAlumnosSalaRoja) {
		this.listaAlumnosSalaRoja = listaAlumnosSalaRoja;
	}

	@Override
	public void asignarCursoParaAlumno(Alumno alumno) throws EdadAlumnoFueraDeRangoException {
		if (alumno.getEdad() < 6)
			this.asignarSala(alumno);
		else
			throw new EdadAlumnoFueraDeRangoException("Edad fuera de Rango para Jardin");
	}

	private Boolean asignarSala(Alumno alumno) throws EdadAlumnoFueraDeRangoException {
		Boolean salaAsignada = false;
		Integer edadAlumno = alumno.getEdad();
		Integer mesNacimiento = alumno.getFechaDeNacimiento().getMonth().getValue();
		switch (edadAlumno) {
		case 3: {
			if (mesNacimiento > 5)
				salaAsignada = listaAlumnosSalaAzul.add(alumno);
			else
				salaAsignada = listaAlumnosSalaVerde.add(alumno);
			break;
		}
		case 4: {
			if (mesNacimiento > 5)
				salaAsignada = listaAlumnosSalaVerde.add(alumno);
			else
				salaAsignada = listaAlumnosSalaRoja.add(alumno);

			break;
		}
		case 5: {
			if (mesNacimiento > 5)
				salaAsignada = listaAlumnosSalaRoja.add(alumno);
			else
				salaAsignada = listaAlumnosSalaAzul.add(alumno);
			;

			break;
		}
		default:
			throw new EdadAlumnoFueraDeRangoException("Edad fuera de rango para Jardin");
		}

		return salaAsignada;

	}


	@Override
	public Persona buscarAlumnoPorDni(Integer dni) throws AlumnoInexistenteException {
	    for (Alumno alumno : listaAlumnosSalaAzul) {
	        if (alumno.getDni().equals(dni)) {
	            return alumno;
	        }
	    }
	    
	    for (Alumno alumno : listaAlumnosSalaVerde) {
	        if (alumno.getDni().equals(dni)) {
	            return alumno;
	        }
	    }
	    
	    for (Alumno alumno : listaAlumnosSalaRoja) {
	        if (alumno.getDni().equals(dni)) {
	            return alumno;
	        }
	    }
	    
	    // If the loop completes without finding the student
	    throw new AlumnoInexistenteException("El DNI no se encuentra inscrito en ningún curso de Jardín.");
	}

}
