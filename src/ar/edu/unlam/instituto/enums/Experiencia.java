package ar.edu.unlam.instituto.enums;

public enum Experiencia {
 JARDIN("JARDIN"),PRIMARIA("PRIMARIA"),CASTELLANO("SECUNDARIA"),MATEMATICA("SECUNDARIA"),GEOGRAFIA("SECUNDARIA"),
 HISTORIA("SECUNDARIA");
 private String nivel;

private Experiencia(String nivel) {
	 this.setNivel(nivel);
 }

public String getNivel() {
	return nivel;
}

public void setNivel(String nivel) {
	this.nivel = nivel;
}
}
