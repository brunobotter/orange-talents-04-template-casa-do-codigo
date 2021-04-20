package br.com.orange.projeto1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.projeto1.form.CategoriaForm;
import br.com.orange.projeto1.modelo.Categoria;
import br.com.orange.projeto1.repository.CategoriaRepository;

@Component
public class ProibeNomeCategoriaDuplicado implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CategoriaForm form = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(form.getNome());
		if(categoria.isPresent()) {
			errors.rejectValue("nome", null, "Ja existe categoria com mesmo nome cadastrada!");
		}
	}

}
