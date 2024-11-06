package ar.edu.unlam.instituto.persona;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona implements Comparable<Persona> {
	private Integer dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;

	public Persona(Integer dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.setApellido(apellido);
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Integer getEdad() {
		Integer edad = LocalDate.now().getYear() - this.getFechaDeNacimiento().getYear();
		return edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int compareTo(Persona o) {
		return this.apellido.compareTo(o.getApellido());
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ",apellido=" + apellido + " fechaDeNacimiento="
				+ fechaDeNacimiento + "]";
	}

}
