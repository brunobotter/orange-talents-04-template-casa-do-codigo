package br.com.orange.projeto1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.orange.projeto1.modelo.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long>{

	Optional<Livro> findByTitulo(String titulo);
	Optional<Livro> findByIsbn(String isbn);
}
