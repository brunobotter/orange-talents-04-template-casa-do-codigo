package br.com.orange.projeto1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.projeto1.form.AutorForm;
import br.com.orange.projeto1.modelo.Autor;
import br.com.orange.projeto1.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorForm form = (AutorForm) target;
		Optional<Autor> autor = autorRepository.findByEmail(form.getEmail());
		if(autor.isPresent()) {
			errors.rejectValue("email", null, "Ja existe email cadastrado no sistema");
		}
	}

}
