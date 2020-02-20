package br.com.contmatic.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * The Class ValidateAnnotations.
 *
 * @param <T> the generic type
 */
public final class ValidateAnnotations {

    private ValidateAnnotations() {

    }

    /**
     * Return annotation msg error.
     *
     * @param t the t
     * @return the string
     */
    public static boolean returnAnnotationMsgError(Object objetoValidate) {

        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> erros = validador.validate(objetoValidate);
        List<String> errosMsg = new ArrayList<>();
        for(ConstraintViolation<Object> teste : erros) {
            errosMsg.add(teste.getMessage());
        }
        String verificaErros = errosMsg.toString();
        errosMsg.toString().replace("[", "").replace("]", "");
        if (verificaErros.length() > 2) {
            return true;
        } else {
            return false;
        }
    }
}
