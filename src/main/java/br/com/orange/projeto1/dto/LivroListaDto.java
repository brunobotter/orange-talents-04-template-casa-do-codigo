package br.com.orange.projeto1.dto;

import br.com.orange.projeto1.modelo.Livro;

public class LivroListaDto {

	private Long idLivro;
	private String titulo;
	
	
	
	public LivroListaDto(Livro l) {
		this.idLivro = l.getId();
		this.titulo = l.getTitulo();
	}

	public Long getIdLivro() {
		return idLivro;
	}
	public String getTitutlo() {
		return titulo;
	}

	
}
	
