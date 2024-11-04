package ar.edu.unlam.instituto;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Persona;

public class Instituto {

	private String nombreInstituto;
	private Integer numero;
	private Integer distritoEducativo;
	private Set<Alumno> registroGralAlumnos;

	public Instituto(String nombreInstituto, Integer numero, Integer distritoEducativo) {
		this.nombreInstituto = nombreInstituto;
		this.numero = numero;
		this.distritoEducativo = distritoEducativo;
		registroGralAlumnos = new TreeSet<Alumno>();
	}

	public String getNombreInstituto() {
		return nombreInstituto;
	}

	public void setNombreInstituto(String nombreInstituto) {
		this.nombreInstituto = nombreInstituto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getDistritoEducativo() {
		return distritoEducativo;
	}

	public void setDistritoEducativo(Integer distritoEducativo) {
		this.distritoEducativo = distritoEducativo;
	}

	/**
	 * @return the registroGralAlumnos
	 */
	public Set<Alumno> getRegistroGralAlumnos() {
		return registroGralAlumnos;
	}

	/**
	 * @param registroGralAlumnos the registroGralAlumnos to set
	 */
	public void setRegistroGralAlumnos(Set<Alumno> registroGralAlumnos) {
		this.registroGralAlumnos = registroGralAlumnos;
	}

	@Override
	public String toString() {
		return "Instituto [nombreInstituto=" + nombreInstituto + ", numero=" + numero + ", distritoEducativo="
				+ distritoEducativo + "]";
	}

	public Boolean inscribirAlumno(Alumno alumno) throws EdadAlumnoFueraDeRangoException {
		Boolean alumnoInscripto = false;
		if (alumno.getEdad() > 2)
			alumnoInscripto = registroGralAlumnos.add(alumno);
		else
			throw new EdadAlumnoFueraDeRangoException(
					"La Edad de la Persona no alcanza la edad minima para la incripcion");
		return alumnoInscripto;
	}

	public Persona buscarAlumnoPorDni(Integer dni) throws AlumnoInexistenteException {
		for (Alumno alumno : registroGralAlumnos) {
			if (alumno.getDni().equals(dni))
				return alumno;
			
		}
		throw new AlumnoInexistenteException("El dni Ingresado no corresponde a ningun alumno de la institutcion");
	}

}
