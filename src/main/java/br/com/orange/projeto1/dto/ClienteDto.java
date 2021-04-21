package br.com.orange.projeto1.dto;

import br.com.orange.projeto1.modelo.Cliente;

public class ClienteDto {

	private Long id;
	
	public ClienteDto() {
		
	}

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}

}
