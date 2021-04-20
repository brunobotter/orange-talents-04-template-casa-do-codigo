package br.com.orange.projeto1.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.projeto1.dto.LivroDto;
import br.com.orange.projeto1.form.LivroForm;
import br.com.orange.projeto1.modelo.Livro;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> salvar(@Valid @RequestBody LivroForm form){
		Livro livro = form.converteToModel(manager);
		manager.persist(livro);
		return ResponseEntity.ok(new LivroDto(livro));
	}
}
