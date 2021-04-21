package br.com.orange.projeto1.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orange.projeto1.form.ClienteForm;
import br.com.orange.projeto1.modelo.Estado;
import br.com.orange.projeto1.modelo.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}

		ClienteForm request = (ClienteForm) target;

		Pais pais = manager.find(Pais.class, request.getIdPais());
		Estado estado = manager.find(Estado.class, request.getIdEstado());

		if(!estado.pertenceAPais(pais)) {
			errors.rejectValue("idEstado",null,"este estado não é o do país selecionado");
		}

	}

}
