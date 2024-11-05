package ar.edu.unlam.PruebasEntrega_4;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.instituto.Instituto;
import ar.edu.unlam.instituto.cursos.Curso;
import ar.edu.unlam.instituto.cursos.Division;
import ar.edu.unlam.instituto.cursos.Grado;
import ar.edu.unlam.instituto.cursos.Sala;
import ar.edu.unlam.instituto.enums.Experiencia;
import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.exceptions.AlumnoInexistenteException;
import ar.edu.unlam.instituto.exceptions.EdadAlumnoFueraDeRangoException;
import ar.edu.unlam.instituto.interfaces.Jardin;
import ar.edu.unlam.instituto.interfaces.Primaria;
import ar.edu.unlam.instituto.interfaces.Secundaria;
import ar.edu.unlam.instituto.persona.Alumno;
import ar.edu.unlam.instituto.persona.Docente;
import ar.edu.unlam.instituto.persona.Persona;

public class Entrga_4DisenioClases {

	@Test //#1
	public void queExistaUnaInstitucionEducativaConCursoSalaNivelJardin() {
		//ENTRADA
		Instituto instituto;
		Jardin sala;
		String nombreInstituto="13 de Julio",codigoCurso="J01";
		Integer numero=01,distritoEducativo=13;
		Integer cicloLectivo=LocalDate.now().getYear();
		Nivel nivel=Nivel.AZUL;		
		//PREPARACION
		instituto=new Instituto(nombreInstituto,numero,distritoEducativo);		
		sala=new Sala(codigoCurso,cicloLectivo,nivel);
		//VALIDACION
		assertNotNull(instituto);
		String vo= codigoCurso;
		String ve = ((Curso) sala).getCodigoCurso();
		assertEquals(ve,vo);
	}
	
	@Test //#2
	public void queExistaUnaInstitucionEducativaConCursoGradoNivelPrimaria() {
		//ENTRADA
		Instituto instituto;
		Primaria grado;
		String nombreInstituto="13 de Julio",codigoCurso="J01";
		Integer numero=01,distritoEducativo=13;
		Integer cicloLectivo=LocalDate.now().getYear();
		Nivel nivel=Nivel.PRIMER_GRADO;		
		//PREPARACION
		instituto=new Instituto(nombreInstituto,numero,distritoEducativo);		
		grado=new Grado(codigoCurso,cicloLectivo,nivel);		
		//VALIDACION
		assertNotNull(instituto);
		String vo= codigoCurso;
		String ve = ((Curso) grado).getCodigoCurso();
		assertEquals(ve,vo);
	}
	
	@Test //#3
	public void queExistaUnaInstitucionEducativaConCursoDivisionNivelSecundaria() {
		//ENTRADA
		Instituto instituto;
		Secundaria division;
		String nombreInstituto="13 de Julio",codigoCurso="J01";
		Integer numero=01,distritoEducativo=13;
		Integer cicloLectivo=LocalDate.now().getYear();
		Nivel nivel=Nivel.PRIMER_GRADO;		
		//PREPARACION
		instituto=new Instituto(nombreInstituto,numero,distritoEducativo);		
		division=new Division(codigoCurso,cicloLectivo,nivel);		
		//VALIDACION
		assertNotNull(instituto);
		String vo= codigoCurso;
		String ve = ((Curso) division).getCodigoCurso();
		assertEquals(ve,vo);
	}
	
	@Test //#4
	public void queDadoUnaPersonaSePuedaSerAlumnoODocenteConCaracteristicasPropias() {
		//ENTRADA		
		String nombre="Franco",nombre1="Luis",apellido="Colapinto",apellido1="Sanchez";
		Integer dni=111111,dni1=222222;
		LocalDate fechaDeNacimiento=LocalDate.of(1995, 12, 12),fechaDeNacimiento1=LocalDate.of(2020, 10, 10);
		Experiencia experiencia= Experiencia.PRIMARIA;
		Persona alumno;
		Integer edad; 
		Persona docente;		
		//PREPARACION
		alumno=new Alumno(dni,nombre,apellido,fechaDeNacimiento);		
		docente=new Docente(dni1,nombre1,apellido1,fechaDeNacimiento1,experiencia);
		edad=alumno.getEdad();		
		//VALIDACION
		Integer vo1= edad;
		Integer ve1=alumno.getEdad();
		Experiencia vo= ((Docente) docente).getExperiencia();
		Experiencia ve = Experiencia.PRIMARIA;
		assertEquals(ve,vo);
		assertEquals(ve1,vo1);
	}
	
	@Test //#5
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
	
	@Test //#6
	//@ Se altera el dni de busqueda para forzar el flujo lance la Excepcion
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
	@Test // #7
	public void queUnAlumnoPuedaRegistrarSuAsistenciaAClase()  {
		// INCIO
		
		Alumno alumno;
		String  nombre = "Facundo", apellido = "Colapinto";
		Integer  dni = 111111;
		Boolean presente = true;
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10),fecha=LocalDate.now();
		
		// PREPARACION
		
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		// VALIDACION
		assertTrue(alumno.registrarAsistencia(fecha,presente));
		
	}



}
