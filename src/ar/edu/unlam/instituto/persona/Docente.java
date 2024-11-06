package ar.edu.unlam.instituto.persona;

import java.time.LocalDate;

import ar.edu.unlam.instituto.enums.Experiencia;

public class Docente extends Persona {

	private Experiencia experiencia;

	public Docente(Integer dni, String nombre, String apellido, LocalDate fechaDeNacimiento, Experiencia experiencia) {
		super(dni, nombre, apellido, fechaDeNacimiento);
		this.setExperiencia(experiencia);
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	

}
