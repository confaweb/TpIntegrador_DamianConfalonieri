package ar.edu.unlam.PruebasEntrega_4;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.instituto.Instituto;
import ar.edu.unlam.instituto.cursos.Sala;
import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Secundaria;
import ar.edu.unlam.instituto.persona.Alumno;

public class Entrga_4CasosInscripcion {

	@Test //#1
	public void queUnaPersonade4AniosSePuedaInscribirEnElInstituto() throws EdadAlumnoFueraDeRangoException {
		//INCIO
		Instituto instituto;
		Alumno alumno;
		String nombreInstituto="13 de Julio",codigoCurso="J01",nombre="Facundo",apellido="Colapinto";
		Integer numero=01,distritoEducativo=13,dni=111111;
		Integer cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento=LocalDate.of(2020,10, 10);
		Nivel nivel=Nivel.AZUL;
		//PREPARACION
		instituto =new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno =new Alumno(dni,nombre,apellido,fechaDeNacimiento);
		//VALIDACION
		assertTrue(instituto.inscribirAlumno(alumno));
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
	}
	@Test //#2
	public void queUnAlumnoDe4AniosInscriptoEnElInstitutoSeLePuedaAsignarSala()throws EdadAlumnoFueraDeRangoException{
		//INCIO
		Instituto instituto;
		Alumno alumno;
		Sala sala;
		String nombreInstituto="13 de Julio",codigoCurso="J01",nombre="Facundo",apellido="Colapinto";
		Integer numero=01,distritoEducativo=13,dni=111111;
		Integer cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento=LocalDate.of(2020,10, 10);
		Nivel nivel=Nivel.AZUL;
		
		//PREPARACION
		instituto =new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno =new Alumno(dni,nombre,apellido,fechaDeNacimiento);
		sala =new Sala(codigoCurso, cicloLectivo, nivel);
		
		sala.asignarCursoParaAlumno(alumno);
		//VALIDACION
		
		assertEquals(1,sala.getListaAlumnosSalaVerde().size());
		assertEquals(apellido,sala.getListaAlumnosSalaVerde().iterator().next().getApellido());
	}
	@Test(expected=EdadAlumnoFueraDeRangoException.class) //#3
	public void queUnAlumnoDe8AniosArrojeExcepcionSiSeLeQuiereAsignarUnaSala() throws EdadAlumnoFueraDeRangoException{
		//INCIO
		Instituto instituto;
		Alumno alumno;
		Sala sala;
		String nombreInstituto="13 de Julio",codigoCurso="J01",nombre="Facundo",apellido="Colapinto";
		Integer numero=01,distritoEducativo=13,dni=111111;
		Integer cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento=LocalDate.of(2016,10, 10);
		Nivel nivel=Nivel.AZUL;
		
		//PREPARACION
		instituto =new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno =new Alumno(dni,nombre,apellido,fechaDeNacimiento);
		sala =new Sala(codigoCurso, cicloLectivo, nivel);
		sala.asignarCursoParaAlumno(alumno);
		//VALIDACION
		
		
	}


}
