package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.entity.Compra;
import br.com.alura.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public ResponseEntity<Compra> realizaCompra(@RequestBody CompraDTO compraDTO) {
		//Utiliza RestTemplate
		//compraService.reailzaCompra(compraDTO);
		
		//Utilliza FeignClient
		Compra compra = compraService.realizarCompraFeign(compraDTO);
		
		return new ResponseEntity<Compra>( compra, HttpStatus.OK);
	}
}
