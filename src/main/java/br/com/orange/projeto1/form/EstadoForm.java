package br.com.orange.projeto1.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.orange.projeto1.modelo.Estado;
import br.com.orange.projeto1.modelo.Pais;
import br.com.orange.projeto1.validator.NaoExisteId;
import br.com.orange.projeto1.validator.UniqueValue;

public class EstadoForm {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Ja existe outro estado com esse nome cadastrado!")
	private String nome;

	@NotNull
	@NaoExisteId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public Estado converteToModel(EntityManager manager) {
		return new Estado(nome, manager.find(Pais.class, idPais));
	}

	public EstadoForm(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}



}
