package ar.edu.unlam.instituto.persona;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.instituto.cursos.Curso;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.interfaces.Asistencia;

public class Alumno extends Persona implements Asistencia {

	private Set<Curso> cursosAprobados;
	private Map<LocalDate, Boolean> asistencia;
	private Boolean asistirAClase;

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
		super(dni, nombre, apellido, fechaDeNacimiento);
		this.cursosAprobados = new HashSet<Curso>();
		this.asistencia = new HashMap<LocalDate, Boolean>();
	}

	/**
	 * @return the asistirAClase
	 */
	public Boolean getAsistirAClase() {
		return asistirAClase;
	}

	/**
	 * @param asistirAClase the asistirAClase to set
	 */
	public void setAsistirAClase(Boolean asistirAClase) {
		this.asistirAClase = asistirAClase;
	}

	public Map<LocalDate, Boolean> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Map<LocalDate, Boolean> asistencia) {
		this.asistencia = asistencia;
	}

	public Set<Curso> getCursosAprobados() {
		return cursosAprobados;
	}

	public void setCursosAprobados(HashSet<Curso> cursosAprobados) {
		this.cursosAprobados = cursosAprobados;
	}

	public Boolean registrarAsistencia(LocalDate fecha) {
		Boolean asistenciaRegistrada = false;
		if (asistencia.get(fecha) == null) {
			this.asistir();
			asistencia.put(fecha, asistirAClase);
			asistenciaRegistrada = true;
		}

		return asistenciaRegistrada;
	}

	private void faltar() {
		this.setAsistirAClase(false);

	}

	private void asistir() {
		this.setAsistirAClase(true);
	}

	@Override
	public Boolean asistirAClase(Curso curso, LocalDate fecha) throws AlumnoInexistenteException {
		this.asistir();
		if (curso.getListaAlumnosPorCurso().contains(this) && asistencia.get(fecha) == null) {
			asistencia.put(fecha, this.asistirAClase);
		} else
			throw new AlumnoInexistenteException("Alumno no se encuantra registrado en el curso de referencia");
		return this.asistirAClase;
	}

	@Override
	public Boolean faltarAClase(Curso curso, LocalDate fecha) throws AlumnoInexistenteException {
		this.faltar();
		if (curso.getListaAlumnosPorCurso().contains(this) && asistencia.get(fecha) == null) {
			asistencia.put(fecha, this.asistirAClase);
		} else
			throw new AlumnoInexistenteException("Alumno no se encuantra registrado en el curso de referencia");
		return this.asistirAClase;
	}

	public Double calcularPorcentajeAsistencia() {
		Double porcentajeAsistencia = 0.0;
		
		Integer asistencias = 0;
		
		for (Boolean value : this.getAsistencia().values()) {
			if (value)
				asistencias++;

		}
		porcentajeAsistencia = (asistencias * 100.0) / this.getAsistencia().size();
		return porcentajeAsistencia;
		// TODO Auto-generated method stub

	}

}
