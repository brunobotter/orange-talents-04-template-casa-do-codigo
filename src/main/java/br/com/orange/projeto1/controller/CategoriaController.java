package br.com.orange.projeto1.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.projeto1.dto.CategoriaDto;
import br.com.orange.projeto1.form.CategoriaForm;
import br.com.orange.projeto1.modelo.Categoria;
import br.com.orange.projeto1.validator.ProibeNomeCategoriaDuplicado;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private ProibeNomeCategoriaDuplicado proibeNomeCategoriaDuplicado;

	@PersistenceContext
	private EntityManager manager;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeCategoriaDuplicado);
	}
	

	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> salvar(@Valid @RequestBody CategoriaForm form) {
		Categoria categoria = form.converteToModel();
		manager.persist(categoria);
		return ResponseEntity.ok(new CategoriaDto(categoria));
	}

}
