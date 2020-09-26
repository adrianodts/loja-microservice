package br.com.alura.microservice.loja.dto;

public class EnderecoDTO {

	private String rua;
	private String numero;
	private String Estado;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@Override
	public String toString() {
		return "EnderecoDTO [rua=" + rua + ", numero=" + numero + ", Estado=" + Estado + "]";
	}
}
