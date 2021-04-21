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

import br.com.orange.projeto1.dto.ClienteDto;
import br.com.orange.projeto1.form.ClienteForm;
import br.com.orange.projeto1.modelo.Cliente;
import br.com.orange.projeto1.validator.EstadoPertenceAPaisValidator;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAPaisValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> salvar(@RequestBody @Valid ClienteForm form){
		Cliente cliente = form.converteToModel(manager);
		manager.persist(cliente);
		return ResponseEntity.ok(new ClienteDto(cliente));
	}
}
