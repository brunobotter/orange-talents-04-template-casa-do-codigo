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

import br.com.orange.projeto1.dto.PaisDto;
import br.com.orange.projeto1.form.PaisForm;
import br.com.orange.projeto1.modelo.Pais;

@RestController
@RequestMapping("/pais")
public class PaisController {

	
	@PersistenceContext
	private EntityManager manager;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDto> salvar(@RequestBody @Valid PaisForm form){
		Pais pais = form.converteToModel();
		manager.persist(pais);
		return ResponseEntity.ok(new PaisDto(pais));
	}
}
