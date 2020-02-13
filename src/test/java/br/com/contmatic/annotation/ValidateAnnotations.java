package br.com.contmatic.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.google.common.base.Preconditions;

/**
 * The Class ValidateAnnotations.
 *
 * @param <T> the generic type
 */
public class ValidateAnnotations<T> {

    /**
     * Return annotation msg error.
     *
     * @param t the t
     * @return the string
     */
    public String returnAnnotationMsgError(T t) {
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> erros = validador.validate(t);
        List<String> errosMsg = new ArrayList<>();
        for(ConstraintViolation<T> teste : erros) {
            errosMsg.add(teste.getMessage());
        }
        String verificaErros = errosMsg.toString();
        Preconditions.checkArgument(!(verificaErros.length() > 2), verificaErros);
        return errosMsg.toString().replace("[", "").replace("]", "");

    }
}