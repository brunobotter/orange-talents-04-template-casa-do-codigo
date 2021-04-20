package br.com.orange.projeto1.form;

import javax.validation.constraints.NotBlank;

import br.com.orange.projeto1.modelo.Pais;
import br.com.orange.projeto1.validator.UniqueValue;

public class PaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Ja existe país cadastrado com esse nome!")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Pais converteToModel() {
		return new Pais(nome);
	}

}
