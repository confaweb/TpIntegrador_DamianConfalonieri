package ar.edu.unlam.PruebasEntrega_4;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.instituto.Instituto;
import ar.edu.unlam.instituto.cursos.Sala;
import ar.edu.unlam.instituto.enums.Experiencia;
import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.CantidadDocentesInsuficienteException;
import ar.edu.unlam.instituto.exceptions.DocenteSinExperienciaAcreditadaException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Secundaria;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Docente;

public class Entrga_4CasosJardin {

	@Test // #1
	public void queUnaPersonade4AniosSePuedaInscribirEnElInstituto() throws EdadAlumnoFueraDeRangoException {
		// INCIO
		Instituto instituto;
		Alumno alumno;
		String nombreInstituto = "13 de Julio", codigoCurso = "J01", nombre = "Facundo", apellido = "Colapinto";
		Integer numero = 01, distritoEducativo = 13, dni = 111111;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10);
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		instituto = new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		// VALIDACION
		assertTrue(instituto.inscribirAlumno(alumno));
		assertEquals(alumno.getApellido(), instituto.getRegistroGralAlumnos().iterator().next().getApellido());
	}

	@Test // #2
	public void queUnAlumnoDe4AniosInscriptoEnElInstitutoSeLePuedaAsignarSala() throws EdadAlumnoFueraDeRangoException {
		// INCIO
		Instituto instituto;
		Alumno alumno;
		Sala sala;
		String nombreInstituto = "13 de Julio", codigoCurso = "J01", nombre = "Facundo", apellido = "Colapinto";
		Integer numero = 01, distritoEducativo = 13, dni = 111111;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10);
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		instituto = new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		sala = new Sala(codigoCurso, cicloLectivo, nivel);
		sala.asignarCursoParaAlumno(alumno);
		// VALIDACION
		assertEquals(1, sala.getListaAlumnosSalaVerde().size());
		assertEquals(apellido, sala.getListaAlumnosSalaVerde().iterator().next().getApellido());
	}

	/* @ Se modifica fechaDeNacimiento para que el flujo vaya por la Excepcion */

	@Test(expected = EdadAlumnoFueraDeRangoException.class) // #3
	public void queUnAlumnoDe8AniosArrojeExcepcionSiSeLeQuiereAsignarUnaSala() throws EdadAlumnoFueraDeRangoException {
		// INCIO
		Instituto instituto;
		Alumno alumno;
		Sala sala;
		String nombreInstituto = "13 de Julio", codigoCurso = "J01", nombre = "Facundo", apellido = "Colapinto";
		Integer numero = 01, distritoEducativo = 13, dni = 111111;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2016, 10, 10);
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		instituto = new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		sala = new Sala(codigoCurso, cicloLectivo, nivel);
		sala.asignarCursoParaAlumno(alumno);
		// VALIDACION

	}

	@Test // #4
	public void BuscarAlumnoPorDniEnCurso() throws EdadAlumnoFueraDeRangoException, AlumnoInexistenteException {
		// INCIO
		Alumno alumno, alumno1, alumno2;
		Sala sala, sala1, sala2;
		Instituto instituto;
		String codigoCurso = "J01", codigoCurso1 = "J02", codigoCurso2 = "J03", nombre = "Facundo", nombre1 = "Hernan",
				nombre2 = "Javier", apellido = "Colapinto", apellido1 = "Hamilton", apellido2 = "Verstappen",
				nombreInstituto = "13 de Julio";
		Integer dni = 111111, dni1 = 222222, dni2 = 333333, numero = 01, distritoEducativo = 13;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10), fechaDeNacimiento1 = LocalDate.of(2019, 10, 10),
				fechaDeNacimiento2 = LocalDate.of(2021, 10, 10);
		Nivel nivel = Nivel.AZUL, nivel1 = Nivel.VERDE, nivel2 = Nivel.ROJA;
		// PREPARACION
		instituto = new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		alumno1 = new Alumno(dni1, nombre1, apellido1, fechaDeNacimiento1);
		alumno2 = new Alumno(dni2, nombre2, apellido2, fechaDeNacimiento2);
		sala = new Sala(codigoCurso, cicloLectivo, nivel);
		sala1 = new Sala(codigoCurso1, cicloLectivo, nivel1);
		sala2 = new Sala(codigoCurso2, cicloLectivo, nivel2);
		sala.asignarCursoParaAlumno(alumno);
		sala.asignarCursoParaAlumno(alumno1);
		sala.asignarCursoParaAlumno(alumno2);

		// VALIDACION

		assertEquals(alumno, sala.buscarAlumnoPorDni(dni));
		assertEquals(alumno1, sala.buscarAlumnoPorDni(dni1));
		assertEquals(alumno2, sala.buscarAlumnoPorDni(dni2));

	}

	@Test // #5
	(expected = AlumnoInexistenteException.class)
	public void BuscarAlumnoPorDniEnInstitutoConResultadoNegativo()
			throws EdadAlumnoFueraDeRangoException, AlumnoInexistenteException {
		// INCIO

		Alumno alumno;
		Alumno alumno1;
		Alumno alumno2;
		Sala sala;
		Instituto instituto;
		String codigoCurso = "J01", nombre = "Facundo", nombre1 = "Hernan", nombre2 = "Javier", apellido = "Colapinto",
				apellido1 = "Hamilton", apellido2 = "Verstappen", nombreInstituto = "13 de Julio";
		Integer dni = 111111, dni1 = 222222, dni2 = 333333, numero = 01, distritoEducativo = 13;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10), fechaDeNacimiento1 = LocalDate.of(2019, 10, 10),
				fechaDeNacimiento2 = LocalDate.of(2021, 10, 10);
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		instituto = new Instituto(nombreInstituto, numero, distritoEducativo);

		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		alumno1 = new Alumno(dni1, nombre1, apellido1, fechaDeNacimiento1);
		alumno2 = new Alumno(dni2, nombre2, apellido2, fechaDeNacimiento2);

		sala = new Sala(codigoCurso, cicloLectivo, nivel);

		sala.asignarCursoParaAlumno(alumno);
		sala.asignarCursoParaAlumno(alumno1);
		sala.asignarCursoParaAlumno(alumno2);

		assertTrue(instituto.inscribirAlumno(alumno));
		assertTrue(instituto.inscribirAlumno(alumno1));
		assertTrue(instituto.inscribirAlumno(alumno2));

		assertEquals(alumno.getApellido(), instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(), instituto.getRegistroGralAlumnos().iterator().next().getApellido());
		assertEquals(alumno.getApellido(), instituto.getRegistroGralAlumnos().iterator().next().getApellido());

		// VALIDACION
		assertEquals(alumno, sala.buscarAlumnoPorDni(444444));

	}

	@Test // #6
	public void queCadaCursoJardinCuenteconSuListadoDeAlumnosPorSala() throws EdadAlumnoFueraDeRangoException {
		// INCIO
		Alumno alumno;
		Alumno alumno1;
		Alumno alumno2;
		Sala sala;
		Instituto instituto;
		String codigoCurso = "J01", nombre = "Facundo", nombre1 = "Hernan", nombre2 = "Javier", apellido = "Colapinto",
				apellido1 = "Hamilton", apellido2 = "Verstappen", nombreInstituto = "13 de Julio";
		Integer dni = 111111, dni1 = 222222, dni2 = 333333, numero = 01, distritoEducativo = 13;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10), fechaDeNacimiento1 = LocalDate.of(2019, 10, 10),
				fechaDeNacimiento2 = LocalDate.of(2021, 10, 10);
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		instituto = new Instituto(nombreInstituto, numero, distritoEducativo);
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		alumno1 = new Alumno(dni1, nombre1, apellido1, fechaDeNacimiento1);
		alumno2 = new Alumno(dni2, nombre2, apellido2, fechaDeNacimiento2);
		sala = new Sala(codigoCurso, cicloLectivo, nivel);
		sala.asignarCursoParaAlumno(alumno);
		sala.asignarCursoParaAlumno(alumno1);
		sala.asignarCursoParaAlumno(alumno2);

		assertTrue(instituto.inscribirAlumno(alumno));
		assertTrue(instituto.inscribirAlumno(alumno1));
		assertTrue(instituto.inscribirAlumno(alumno2));
		// VALIDACION
		assertTrue(sala.getListaAlumnosSalaVerde().contains(alumno));
		assertTrue(sala.getListaAlumnosSalaRoja().contains(alumno1));
		assertTrue(sala.getListaAlumnosSalaAzul().contains(alumno2));

		assertEquals(alumno.getApellido(), sala.getListaAlumnosSalaVerde().iterator().next().getApellido());
		assertEquals(alumno1.getApellido(), sala.getListaAlumnosSalaRoja().iterator().next().getApellido());
		assertEquals(alumno2.getApellido(), sala.getListaAlumnosSalaAzul().iterator().next().getApellido());
	}

	@Test // #7
	public void dadoUnCursoDeJardinVerificarqueTengaDosDocentesACargo()
			throws CantidadDocentesInsuficienteException, DocenteSinExperienciaAcreditadaException {
		// INCIO

		Sala sala;
		Docente docente, docente2;

		String codigoCurso = "J01", codigoCurso1 = "J02", codigoCurso2 = "J03", nombre = "Facundo", nombre1 = "Hernan",
				nombre2 = "Javier", apellido = "Colapinto", apellido1 = "Hamilton", apellido2 = "Verstappen",
				nombreInstituto = "13 de Julio";
		Integer dni = 111111, dni1 = 222222, dni2 = 333333, numero = 01, distritoEducativo = 13;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 10, 10), fechaDeNacimiento2 = LocalDate.of(1994, 10, 10);
		Experiencia experiencia = Experiencia.JARDIN, experiencia2 = Experiencia.JARDIN;
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		sala = new Sala(codigoCurso, cicloLectivo, nivel);
		docente = new Docente(dni, nombre, apellido, fechaDeNacimiento, experiencia);
		docente2 = new Docente(dni2, nombre2, apellido2, fechaDeNacimiento2, experiencia2);
		sala.asignarDocentesACargo(docente);
		sala.asignarDocentesACargo(docente2);
		// VALIDACION
		assertTrue(sala.verificarCantidadDocentesACargo());
	}

	@Test // #8
	(expected = CantidadDocentesInsuficienteException.class)
	public void dadoUnCursoDeJardinLanzarExcepcionsiNoTieneDosDocentesACargo()
			throws CantidadDocentesInsuficienteException, DocenteSinExperienciaAcreditadaException {
		// INCIO
		Sala sala;
		Docente docente;

		String codigoCurso = "J01", codigoCurso1 = "J02", codigoCurso2 = "J03", nombre = "Facundo", nombre1 = "Hernan",
				nombre2 = "Javier", apellido = "Colapinto", apellido1 = "Hamilton", apellido2 = "Verstappen",
				nombreInstituto = "13 de Julio";
		Integer dni = 111111, dni1 = 222222, dni2 = 333333, numero = 01, distritoEducativo = 13;
		Integer cicloLectivo = LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 10, 10), fechaDeNacimiento2 = LocalDate.of(1994, 10, 10);
		Experiencia experiencia = Experiencia.JARDIN, experiencia2 = Experiencia.JARDIN;
		Nivel nivel = Nivel.AZUL;
		// PREPARACION
		sala = new Sala(codigoCurso, cicloLectivo, nivel);
		docente = new Docente(dni, nombre, apellido, fechaDeNacimiento, experiencia);		
		sala.asignarDocentesACargo(docente);
		// VALIDACION
		assertTrue(sala.verificarCantidadDocentesACargo());

	}
	
}
