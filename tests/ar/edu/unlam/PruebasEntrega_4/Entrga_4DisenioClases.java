package ar.edu.unlam.PruebasEntrega_4;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.instituto.Instituto;
import ar.edu.unlam.instituto.cursos.Curso;
import ar.edu.unlam.instituto.cursos.Division;
import ar.edu.unlam.instituto.cursos.Grado;
import ar.edu.unlam.instituto.cursos.Sala;
import ar.edu.unlam.instituto.enums.Nivel;
import ar.edu.unlam.instituto.interfaces.Jardin;
import ar.edu.unlam.instituto.interfaces.Primaria;
import ar.edu.unlam.instituto.interfaces.Secundaria;

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


}
