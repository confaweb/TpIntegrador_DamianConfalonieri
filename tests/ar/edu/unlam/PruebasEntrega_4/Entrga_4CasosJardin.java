package ar.edu.unlam.PruebasEntrega_4;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.instituto.Instituto;
import ar.edu.unlam.instituto.cursos.Sala;
import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Secundaria;
import ar.edu.unlam.instituto.persona.Alumno;

public class Entrga_4CasosJardin {

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
	
	/* @ Se modifica fechaDeNacimiento para que el flujo vaya por la Excepcion 		 */
	
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
	@Test //#4
	public void BuscarAlumnoPorDniEnINstituto() throws EdadAlumnoFueraDeRangoException, AlumnoInexistenteException {
		//INCIO
		
		Alumno alumno;
		Alumno alumno1;
		Alumno alumno2;
		Sala sala;
		Instituto instituto;
		String codigoCurso="J01",nombre="Facundo",nombre1="Hernan",nombre2 ="Javier",apellido="Colapinto",
				apellido1 ="Hamilton",apellido2="Verstappen",nombreInstituto="13 de Julio";
		Integer dni=111111, dni1=222222,dni2=333333,numero=01,distritoEducativo=13;
		Integer cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento=LocalDate.of(2020,10, 10),fechaDeNacimiento1=LocalDate.of(2019,10, 10),fechaDeNacimiento2=LocalDate.of(2021,10, 10);
		Nivel nivel=Nivel.AZUL;
		//PREPARACION
		instituto =new Instituto(nombreInstituto,numero,distritoEducativo);
		
		alumno =new Alumno(dni,nombre,apellido,fechaDeNacimiento);
		alumno1 =new Alumno(dni1,nombre1,apellido1,fechaDeNacimiento1);
		alumno2 =new Alumno(dni2,nombre2,apellido2,fechaDeNacimiento2);
		
		sala =new Sala(codigoCurso, cicloLectivo, nivel);
		
		sala.asignarCursoParaAlumno(alumno);
		sala.asignarCursoParaAlumno(alumno1);
		sala.asignarCursoParaAlumno(alumno2);
		
		assertTrue(instituto.inscribirAlumno(alumno));
		assertTrue(instituto.inscribirAlumno(alumno1));
		assertTrue(instituto.inscribirAlumno(alumno2));
		
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		
		//VALIDACION
		
		
		assertEquals(alumno,instituto.buscarAlumnoPorDni(dni));
		assertEquals(alumno1,instituto.buscarAlumnoPorDni(dni1));
		assertEquals(alumno2,instituto.buscarAlumnoPorDni(dni2));
	}
	@Test //#5
	(expected=AlumnoInexistenteException.class)
	public void BuscarAlumnoPorDniEnInstitutoConResultadoNegativo() throws EdadAlumnoFueraDeRangoException, AlumnoInexistenteException {
		//INCIO
		
		Alumno alumno;
		Alumno alumno1;
		Alumno alumno2;
		Sala sala;
		Instituto instituto;
		String codigoCurso="J01",nombre="Facundo",nombre1="Hernan",nombre2 ="Javier",apellido="Colapinto",
				apellido1 ="Hamilton",apellido2="Verstappen",nombreInstituto="13 de Julio";
		Integer dni=111111, dni1=222222,dni2=333333,numero=01,distritoEducativo=13;
		Integer cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento=LocalDate.of(2020,10, 10),fechaDeNacimiento1=LocalDate.of(2019,10, 10),fechaDeNacimiento2=LocalDate.of(2021,10, 10);
		Nivel nivel=Nivel.AZUL;
		//PREPARACION
		instituto =new Instituto(nombreInstituto,numero,distritoEducativo);
		
		alumno =new Alumno(dni,nombre,apellido,fechaDeNacimiento);
		alumno1 =new Alumno(dni1,nombre1,apellido1,fechaDeNacimiento1);
		alumno2 =new Alumno(dni2,nombre2,apellido2,fechaDeNacimiento2);
		
		sala =new Sala(codigoCurso, cicloLectivo, nivel);
		
		sala.asignarCursoParaAlumno(alumno);
		sala.asignarCursoParaAlumno(alumno1);
		sala.asignarCursoParaAlumno(alumno2);
		
		assertTrue(instituto.inscribirAlumno(alumno));
		assertTrue(instituto.inscribirAlumno(alumno1));
		assertTrue(instituto.inscribirAlumno(alumno2));
		
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		
		//VALIDACION
		
		
		assertEquals(alumno,instituto.buscarAlumnoPorDni(444444));
		
	}
	@Test //#6
	public void queCadaCursoJardinCuenteconSuListadoDeAlumnosPorSala() throws EdadAlumnoFueraDeRangoException {
		//INCIO
		
		Alumno alumno;
		Alumno alumno1;
		Alumno alumno2;
		Sala sala;
		Instituto instituto;
		String codigoCurso="J01",nombre="Facundo",nombre1="Hernan",nombre2 ="Javier",apellido="Colapinto",
				apellido1 ="Hamilton",apellido2="Verstappen",nombreInstituto="13 de Julio";
		Integer dni=111111, dni1=222222,dni2=333333,numero=01,distritoEducativo=13;
		Integer cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento=LocalDate.of(2020,10, 10),fechaDeNacimiento1=LocalDate.of(2019,10, 10),fechaDeNacimiento2=LocalDate.of(2021,10, 10);
		Nivel nivel=Nivel.AZUL;
		//PREPARACION
		instituto =new Instituto(nombreInstituto,numero,distritoEducativo);
		
		alumno =new Alumno(dni,nombre,apellido,fechaDeNacimiento);
		alumno1 =new Alumno(dni1,nombre1,apellido1,fechaDeNacimiento1);
		alumno2 =new Alumno(dni2,nombre2,apellido2,fechaDeNacimiento2);
		
		sala =new Sala(codigoCurso, cicloLectivo, nivel);
		
		sala.asignarCursoParaAlumno(alumno);
		sala.asignarCursoParaAlumno(alumno1);
		sala.asignarCursoParaAlumno(alumno2);
		
		assertTrue(instituto.inscribirAlumno(alumno));
		assertTrue(instituto.inscribirAlumno(alumno1));
		assertTrue(instituto.inscribirAlumno(alumno2));
		//VALIDACION
		
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(),instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		
		assertEquals(alumno.getApellido(),sala.getListaAlumnosSalaVerde().iterator().next().getApellido());
		assertEquals(alumno1.getApellido(),sala.getListaAlumnosSalaRoja().iterator().next().getApellido());
		assertEquals(alumno2.getApellido(),sala.getListaAlumnosSalaAzul().iterator().next().getApellido());
	}




}
