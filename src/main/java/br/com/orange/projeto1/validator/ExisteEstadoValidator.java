package br.com.orange.projeto1.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExisteEstadoValidator implements ConstraintValidator<ExisteEstado, Object>{

	private String domain;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ExisteEstado constraintAnnotation) {
		domain = constraintAnnotation.fieldName();
		klass = constraintAnnotation.domainClass();
		}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		List<?> list = manager.createQuery("select 1 from "+klass.getName()+" where "+ domain+"=:value")
				.setParameter("value", value).getResultList();
			for (Object object : list) {
				System.out.println(object);
			}
		return !list.isEmpty();
	}
}
