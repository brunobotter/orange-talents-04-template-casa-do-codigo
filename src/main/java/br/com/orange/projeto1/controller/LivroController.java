package br.com.orange.projeto1.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.projeto1.dto.DetalheLivroDto;
import br.com.orange.projeto1.dto.LivroDto;
import br.com.orange.projeto1.dto.LivroListaDto;
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
	
	@GetMapping
	public ResponseEntity<List<LivroListaDto>> listaLivro(){
		@SuppressWarnings("unchecked")
		List<Livro> lista = manager.createQuery("select l from Livro l").getResultList();
		List<LivroListaDto> dto =  lista.stream().map(l -> new LivroListaDto(l)).collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDto> detalheLivro(@PathVariable Long id){
		Livro livro = manager.find(Livro.class, id);
		if(livro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new DetalheLivroDto(livro));
	}
}