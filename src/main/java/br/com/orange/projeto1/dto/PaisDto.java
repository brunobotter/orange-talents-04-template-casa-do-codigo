package br.com.orange.projeto1.dto;

import br.com.orange.projeto1.modelo.Pais;

public class PaisDto {
	private Long id;
	private String nome;

	public PaisDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
