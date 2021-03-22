package br.com.contmatic.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Setter;

public class ValidateAnnotations<T> {

	@Setter
	public Object classe;

	public boolean isInvalid(T t) {
		try {
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<Object>> violations;
			violations = validator.validate(t);
			Logger LOGGER = LoggerFactory.getLogger(t.getClass());
			violations.forEach(violation -> LOGGER.error(violation.getMessage()));
			return !violations.isEmpty();
		} catch (Exception e) {
			Logger LOGGER = LoggerFactory.getLogger(ValidateAnnotations.class);
			LOGGER.error(e.getMessage(), e);
		}
		return true;
	}
	
	public boolean isFieldInvalid(T t, String expected) {
		try {
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<Object>> violations = validator.validate(t);
			for (ConstraintViolation<Object> constraintViolation : violations) {
				if(constraintViolation.getMessage().equals(expected)) {
					return true;
				}
			}
		} catch (Exception e) {
			Logger LOGGER = LoggerFactory.getLogger(ValidateAnnotations.class);
			LOGGER.error(e.getMessage(), e);
		}
		return false;
	}
}
