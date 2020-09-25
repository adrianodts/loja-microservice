package br.com.alura.microservice.loja.controller.dto;

import java.util.List;

public class CompraDTO {
	
	private List<ItemDaCompraDTO>  item; 
	private EnderecoDTO endereco;
	public List<ItemDaCompraDTO> getItem() {
		return item;
	}
	public void setItem(List<ItemDaCompraDTO> item) {
		this.item = item;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	
}