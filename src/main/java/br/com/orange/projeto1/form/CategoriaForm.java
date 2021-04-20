package br.com.orange.projeto1.form;

import javax.validation.constraints.NotBlank;

import br.com.orange.projeto1.modelo.Categoria;

public class CategoriaForm {

	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converteToModel() {
		return new Categoria(nome);
	}
	
	
}
