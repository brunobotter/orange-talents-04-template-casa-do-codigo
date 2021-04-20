package br.com.orange.projeto1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;

	public Pais(@NotBlank String nome2) {
		this.nome = nome2;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	
	public Pais() {
		
	}

}
