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

import br.com.orange.projeto1.dto.EstadoDto;
import br.com.orange.projeto1.form.EstadoForm;
import br.com.orange.projeto1.modelo.Estado;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> salvar(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.converteToModel(manager);
		manager.persist(estado);
		return ResponseEntity.ok(new EstadoDto(estado));
	}
}
