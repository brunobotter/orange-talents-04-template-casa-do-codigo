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

import br.com.orange.projeto1.dto.AutorDto;
import br.com.orange.projeto1.form.AutorForm;
import br.com.orange.projeto1.modelo.Autor;
import br.com.orange.projeto1.validator.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> salvar(@RequestBody @Valid AutorForm form){
		Autor autor = form.converteToModel();
		manager.persist(autor);
		return ResponseEntity.ok(new AutorDto(autor));
	}
}
