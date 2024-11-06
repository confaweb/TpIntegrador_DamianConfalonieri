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
	public void queUnAlumnoPuedaRegistrarPresenteSuAsistenciaAClase() throws EdadAlumnoFueraDeRangoException,AlumnoInexistenteException  {
		// INCIO
		
		Alumno alumno;
		Curso curso;
		String  nombre = "Facundo", apellido = "Colapinto",codigoCurso="j01";
		Integer  dni = 111111,cicloLectivo=LocalDate.now().getYear();
		Boolean presente = true;
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10),fecha=LocalDate.now();
		Nivel nivel=Nivel.AZUL;
		
		// PREPARACION
		
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		curso=new Sala(codigoCurso, cicloLectivo, nivel);
		curso.asignarCursoParaAlumno(alumno);
		assertTrue(alumno.asistirAClase(curso,fecha));
		// VALIDACION
		Boolean ve=true;
		Boolean vo = alumno.getAsistencia().get(fecha);
		assertEquals(ve,vo);
	}
	@Test // #8
	public void queUnAlumnoPuedaRegistrarAusenteSuAsistenciaAClase() throws EdadAlumnoFueraDeRangoException,AlumnoInexistenteException  {
		// INCIO
		
		Alumno alumno;
		Curso curso;
		String  nombre = "Facundo", apellido = "Colapinto",codigoCurso="j01";
		Integer  dni = 111111,cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10),fecha=LocalDate.now();
		Nivel nivel=Nivel.AZUL;
		
		// PREPARACION
		
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		curso=new Sala(codigoCurso, cicloLectivo, nivel);
		curso.asignarCursoParaAlumno(alumno);
		assertFalse(alumno.faltarAClase(curso,fecha));
		// VALIDACION
		Boolean ve=false;
		Boolean vo = alumno.getAsistencia().get(fecha);
		assertEquals(ve,vo);
	}

	@Test // #9
	public void queUnAlumnoPuedaCalculaSuAsistencia() throws EdadAlumnoFueraDeRangoException, AlumnoInexistenteException  {
		// INCIO
		
		Alumno alumno;
		Curso curso;
		String  nombre = "Facundo", apellido = "Colapinto",codigoCurso="j01";
		Integer  dni = 111111,cicloLectivo=LocalDate.now().getYear();
		LocalDate fechaDeNacimiento = LocalDate.of(2020, 10, 10),fecha=LocalDate.now();
		Nivel nivel=Nivel.AZUL;
		
		// PREPARACION
		
		alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento);
		curso=new Sala(codigoCurso, cicloLectivo, nivel);
		curso.asignarCursoParaAlumno(alumno);
		simuladorAsistenciaMensual(curso,alumno);
		alumno.calcularPorcentajeAsistencia();
		
		// VALIDACION
		Integer ve=22;
		Integer vo = alumno.getAsistencia().size();
		assertEquals(ve,vo);
		Double ve1=77.27;
		Double vo1=alumno.calcularPorcentajeAsistencia();
		assertEquals(ve1,vo1,.01);
		
	}

	private void simuladorAsistenciaMensual(Curso curso, Alumno alumno) throws AlumnoInexistenteException, EdadAlumnoFueraDeRangoException {		
		
		for(int dia=1;dia<=31;dia++) {
			LocalDate fecha=LocalDate.of(2024, 10, dia);
			if(dia%6!=0&&dia%7!=0&&dia%5!=0) // saca 8 dias de los 31 del mes por los fin dde semana(6,7,12,14,18,21,24,28,30)=22 dias de clase en el mes
				alumno.asistirAClase(curso, fecha);	
			else if (dia%5==0&&dia!=30)// simula faltaslos dias 5,10,15,20 y 25-total faltas en el mes :5
				alumno.faltarAClase(curso, fecha);
			
		}
		
	}



}
