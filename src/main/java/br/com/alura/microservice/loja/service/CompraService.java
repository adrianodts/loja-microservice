package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.entity.Compra;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;

	@Autowired
	private FornecedorClient clientFeign;
	
	@Autowired
	private DiscoveryClient eurekaClient;
	
	public void reailzaCompra(CompraDTO compraDTO) {
		//RestTemplate client = new RestTemplate();
		//RestTemplate não consegue resolver o endereco e porta para -> http://fornecedor/
		ResponseEntity<InfoFornecedorDTO> exchange =
			client.exchange("http://fornecedor/info/" + compraDTO.getEndereco().getEstado(), HttpMethod.GET,
					null, InfoFornecedorDTO.class);

		eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
			System.out.println("Instance: " + fornecedor.getHost() + " "  +fornecedor.getPort());
		});
		
		System.out.println(exchange.getBody().getEndereco());
	}
	
	public Compra realizarCompraFeign(CompraDTO dto) {
		
		InfoFornecedorDTO info = clientFeign.getInfoPorEstado(dto.getEndereco().getEstado());
		System.out.println(info.getEndereco());
		
		InfoPedidoDTO pedido = clientFeign.realizaPedido(dto.getItem());
		
		eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
			System.out.println("Instance: " + fornecedor.getHost() + " "  +fornecedor.getPort());
		});
		
		Compra compra = new Compra();
		compra.setPedidoId(pedido.getId());
		compra.setTempoDePreparo(pedido.getTempoDePreparo());
		compra.setEnderecoDestino(dto.getEndereco().toString());
		
		return compra;
	}
	
}
