package br.com.orange.projeto1.form;

import javax.validation.constraints.NotBlank;

import br.com.orange.projeto1.modelo.Categoria;
import br.com.orange.projeto1.validator.UniqueValue;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome", message = "Não pode ter nome de categoria repeditos!")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converteToModel() {
		return new Categoria(nome);
	}
	
	
}
