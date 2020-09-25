package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public ResponseEntity<?> realizaCompra(@RequestBody CompraDTO compraDTO) {
		String msg = "Sucesso";
		
		compraService.reailzaCompra(compraDTO);
		
		return new ResponseEntity<String>( msg, HttpStatus.OK);
	}
}
