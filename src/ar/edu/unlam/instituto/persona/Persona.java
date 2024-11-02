package ar.edu.unlam.instituto.persona;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona {
private Integer dni;
private String nombre;
private LocalDate fechaDeNacimiento;

public Persona(Integer dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
	this.dni=dni;
	this.nombre=nombre;
	this.fechaDeNacimiento=fechaDeNacimiento;
}

public LocalDate getFechaDeNacimiento() {
	return fechaDeNacimiento;
}

public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
	this.fechaDeNacimiento = fechaDeNacimiento;
}
public Integer getEdad() {
	Integer edad=LocalDate.now().getYear()-this.getFechaDeNacimiento().getYear();
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
public String toString() {
	return "Persona [dni=" + dni + ", nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
}


}
