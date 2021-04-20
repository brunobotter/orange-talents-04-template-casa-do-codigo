package br.com.orange.projeto1.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExisteIdValidator implements ConstraintValidator<ExisteId, Object>{

	private String domain;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ExisteId constraintAnnotation) {
		domain = constraintAnnotation.fieldName();
		klass = constraintAnnotation.domainClass();
		}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+ domain+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		return !list.isEmpty();
	}
}
