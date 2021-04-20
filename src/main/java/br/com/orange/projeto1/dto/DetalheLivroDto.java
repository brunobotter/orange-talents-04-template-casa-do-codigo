package br.com.orange.projeto1.dto;

import java.math.BigDecimal;

import br.com.orange.projeto1.modelo.Livro;

public class DetalheLivroDto {

	private Long id;

	private String titulo;

	private String resumo;

	private String sumario;

	private BigDecimal preco;

	private int numeroPaginas;

	private String isbn;

	private String nomeAutor;

	private String descricaoAutor;

	public DetalheLivroDto() {

	}
	
	public DetalheLivroDto(Livro livro) {
		this.id = livro.getId();
		this.isbn = livro.getIsbn();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.descricaoAutor = livro.getAutor().getDescricao();
		this.nomeAutor = livro.getAutor().getNome();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

}
