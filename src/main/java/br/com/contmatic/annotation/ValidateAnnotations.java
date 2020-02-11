package br.com.contmatic.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class ValidateAnnotations<T> {

    public String returnAnnotationMsgError(T t) {
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> erros = validador.validate(t);
        List<String> errosMsg = new ArrayList<>();
        erros.stream().forEach(t1 -> errosMsg.add(t1.getMessage()));
        return errosMsg.toString().replace("[", "").replace("]", "");

    }
}
