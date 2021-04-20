package br.com.orange.projeto1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orange.projeto1.modelo.Livro;

public class LivroDto {

	private Long id;

	private String titulo;

	private String resumo;

	private String sumario;

	private BigDecimal preco;

	private int numeroPaginas;

	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	private String nomeAutor;

	private String nomeCategoria;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.nomeAutor = livro.getAutor().getNome();
		this.nomeCategoria = livro.getCategoria().getNome();
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	
}
