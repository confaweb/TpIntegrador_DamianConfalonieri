package ar.edu.unlam.instituto.cursos;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.instituto.enums.Experiencia;
import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.CantidadDocentesInsuficienteException;
import ar.edu.unlam.instituto.exceptions.DocenteSinExperienciaAcreditadaException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Jardin;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Docente;
import ar.edu.unlam.instituto.persona.OrdenPorDni;
import ar.edu.unlam.instituto.persona.Persona;

public class Sala extends Curso implements Jardin {

	Set<Alumno> listaAlumnosSalaVerde;
	Set<Alumno> listaAlumnosSalaAzul;
	Set<Alumno> listaAlumnosSalaRoja;
	Set<Alumno>listaOrdenadaPorDni;

	public Sala(String codigoCurso, Integer cicloLectivo, Nivel nivel) {
		super(codigoCurso, cicloLectivo, nivel);
		this.listaAlumnosSalaVerde = new TreeSet<Alumno>();
		this.listaAlumnosSalaAzul = new TreeSet<Alumno>();
		this.listaAlumnosSalaRoja = new TreeSet<Alumno>();
		this.listaOrdenadaPorDni=new TreeSet<Alumno>(new OrdenPorDni());
	}

	public Set<Alumno> getListaAlumnosSalaVerde() {
		return listaAlumnosSalaVerde;
	}

	public void setListaAlumnosSalaVerde(Set<Alumno> listaAlumnosSalaVerde) {
		this.listaAlumnosSalaVerde = listaAlumnosSalaVerde;
	}

	public Set<Alumno> getListaAlumnosSalaAzul() {
		return listaAlumnosSalaAzul;
	}

	public void setListaAlumnosSalaAzul(Set<Alumno> listaAlumnosSalaAzul) {
		this.listaAlumnosSalaAzul = listaAlumnosSalaAzul;
	}

	public Set<Alumno> getListaAlumnosSalaRoja() {
		return listaAlumnosSalaRoja;
	}

	public void setListaAlumnosSalaRoja(Set<Alumno> listaAlumnosSalaRoja) {
		this.listaAlumnosSalaRoja = listaAlumnosSalaRoja;
	}

	/**
	 * @return the listaOrdenadaPorDni
	 */
	public Set<Alumno> getListaOrdenadaPorDni() {
		return listaOrdenadaPorDni;
	}

	/**
	 * @param listaOrdenadaPorDni the listaOrdenadaPorDni to set
	 */
	public void setListaOrdenadaPorDni(Set<Alumno> listaOrdenadaPorDni) {
		this.listaOrdenadaPorDni = listaOrdenadaPorDni;
	}

	@Override
	public void asignarCursoParaAlumno(Alumno alumno) throws EdadAlumnoFueraDeRangoException {
		if (alumno.getEdad() < 6) {
			this.listaAlumnosPorCurso.add(alumno);
			this.asignarSala(alumno);
		} else
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

		// Si el dni no se encuentra en la lista de alumnos de los cursos
		throw new AlumnoInexistenteException("El DNI no se encuentra inscripto en ningún curso de Jardín.");
	}

	@Override
	public Boolean verificarCantidadDocentesACargo() throws CantidadDocentesInsuficienteException {
		Boolean docentesVerificados = false;
		if (this.getDocestesACargo().size() < 2)
			throw new CantidadDocentesInsuficienteException(getCodigoCurso());
		else
			docentesVerificados = true;
		return docentesVerificados;
	}

	@Override
	public Boolean asignarDocentesACargo(Docente docente) throws DocenteSinExperienciaAcreditadaException {
		Boolean docenteAsignado = false;
		;
		if (docente.getExperiencia().equals(Experiencia.JARDIN))
			docenteAsignado = this.getDocestesACargo().add(docente);
		else
			throw new DocenteSinExperienciaAcreditadaException("El docente no acredita experiencia requerida");

		return docenteAsignado;

	}

	public void ordenarAlumnosPorDni() {
		this.listaOrdenadaPorDni.addAll(listaAlumnosPorCurso);
		
	}

}
