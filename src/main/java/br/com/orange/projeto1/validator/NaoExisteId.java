package br.com.orange.projeto1.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { NaoExisteIdValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NaoExisteId {

	String message() default "{br.com.orange.projeto1.validator.NaoExisteId}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> domainClass();

}
