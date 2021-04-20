package br.com.orange.projeto1.dto;

import br.com.orange.projeto1.modelo.Estado;

public class EstadoDto {

	private Long id;
	private String nome;

	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
