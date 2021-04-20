package br.com.orange.projeto1.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.orange.projeto1.modelo.Autor;
import br.com.orange.projeto1.validator.UniqueValue;

public class AutorForm {


	public AutorForm() {
	}

	@NotBlank
	private String nome;

	@NotBlank
	@Email(message = "Email é obrigatorio!")
	@UniqueValue(domainClass = Autor.class,fieldName = "email", message = "Não pode ter email repedito no cadastro!")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converteToModel() {
		return new Autor(nome, email, descricao);
	}

}
