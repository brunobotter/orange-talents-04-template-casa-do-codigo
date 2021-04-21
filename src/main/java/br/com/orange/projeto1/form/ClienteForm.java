package br.com.orange.projeto1.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.orange.projeto1.modelo.Cliente;
import br.com.orange.projeto1.modelo.Estado;
import br.com.orange.projeto1.modelo.Pais;
import br.com.orange.projeto1.validator.ExisteCpf;
import br.com.orange.projeto1.validator.NaoExisteId;
import br.com.orange.projeto1.validator.UniqueValue;

public class ClienteForm {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email ja cadastrado no sistema")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPF
	@ExisteCpf(domainClass = Cliente.class, fieldName = "cpf", message = "CPF ja cadastrado no sistema!")
	private String cpf;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@NaoExisteId(domainClass = Pais.class, fieldName = "id", message = "Id do pais nao existe")
	private Long idPais;
	
	@NaoExisteId(domainClass = Estado.class, fieldName = "id",message = "Id do estado nao existe")
	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente converteToModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Estado estado = manager.find(Estado.class, idEstado);
		return new Cliente(email, nome, sobrenome, cpf, endereco, complemento,
				cidade, pais, estado, telefone, cep);
	}

}
