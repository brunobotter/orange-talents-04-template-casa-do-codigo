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

import br.com.orange.projeto1.dto.CategoriaDto;
import br.com.orange.projeto1.form.CategoriaForm;
import br.com.orange.projeto1.modelo.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> salvar(@Valid @RequestBody CategoriaForm form) {
		Categoria categoria = form.converteToModel();
		manager.persist(categoria);
		return ResponseEntity.ok(new CategoriaDto(categoria));
	}

}
