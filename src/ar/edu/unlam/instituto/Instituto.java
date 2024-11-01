package ar.edu.unlam.instituto;

public class Instituto {

	private String nombreInstituto;
	private Integer numero;
	private Integer distritoEducativo;

	public Instituto(String nombreInstituto, Integer numero, Integer distritoEducativo) {
		this.nombreInstituto=nombreInstituto;
		this.numero=numero;
		this.distritoEducativo=distritoEducativo;
	}

	public String getNombreInstituto() {
		return nombreInstituto;
	}

	public void setNombreInstituto(String nombreInstituto) {
		this.nombreInstituto = nombreInstituto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getDistritoEducativo() {
		return distritoEducativo;
	}

	public void setDistritoEducativo(Integer distritoEducativo) {
		this.distritoEducativo = distritoEducativo;
	}

	@Override
	public String toString() {
		return "Instituto [nombreInstituto=" + nombreInstituto + ", numero=" + numero + ", distritoEducativo="
				+ distritoEducativo + "]";
	}

}
