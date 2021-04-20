package br.com.orange.projeto1.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orange.projeto1.modelo.Autor;
import br.com.orange.projeto1.modelo.Categoria;
import br.com.orange.projeto1.modelo.Livro;
import br.com.orange.projeto1.validator.NaoExisteId;
import br.com.orange.projeto1.validator.UniqueValue;

public class LivroForm {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Titulo ja cadastrado no sistema!")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@Min(100)
	@NotNull
	private int numeroPaginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN ja cadastrado no sistema!")
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	@NaoExisteId(domainClass = Autor.class, fieldName = "id", message = "Id autor nao existe no banco")
	private Long idAutor;

	@NotNull
	@NaoExisteId(domainClass = Categoria.class, fieldName = "id", message = "Id categoria nao existe no banco")
	private Long idCategoria;

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

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Livro converteToModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		Assert.state(autor!= null, "Voce esta querendo cadastrar um autor que nao existe no banco"+idAutor);
		Assert.state(categoria!= null, "Voce esta querendo cadastrar uma categoria que nao existe no banco"+idCategoria);
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
	}
	
	
}
