package br.com.orange.projeto1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPF
	private String cpf;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public Cliente() {
		
	}
	
	public Cliente(@Email @NotBlank String email2, @NotBlank String nome2, @NotBlank String sobrenome2,
			@CPF String cpf2, @NotBlank String endereco2, @NotBlank String complemento2, @NotBlank String cidade2,
			Pais pais2, Estado estado2, @NotBlank String telefone2, @NotBlank String cep2) {
		this.email = email2;
		this.nome = nome2;
		this.sobrenome = sobrenome2;
		this.cpf = cpf2;
		this.endereco = endereco2;
		this.complemento = complemento2;
		this.cidade = cidade2;
		this.pais = pais2;
		this.estado = estado2;
		this.telefone = telefone2;
		this.cep = cep2;
	}

	public Long getId() {
		return id;
	}

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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
