package ar.edu.unlam.instituto.enums;

public enum Nivel {
	AZUL("Jardin"), ROJA("Jardin"), VERDE("Jardin"), CELESTE("Jardin"), PRIMER_GRADO("Primaria"),
	SEGUNDO_GRADO("Primaria"), TERCER_GRADO("Primaria"), CUARTO_GRADO("Primaria"), QUINTO_GRADO("Primaria"),
	SEXTO_GRADO("Primaria"), SEPTIMO_GRADO("Primaria"), PRIMER_ANIO("Secundaria"), SEGUNDO_ANIO("Secundaria"),
	TERCER_ANIO("Secundaria"), CUARTO_ANIO("Secundaria"), QUINTO_ANIO("Secundaria"), SEXTO_ANIO("Secundaria");

	private String ciclo;

	Nivel(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCiclo() {
		return this.ciclo;
	}
}
