package br.com.contmatic.utils;

import java.time.LocalDate;
import java.time.Period;

import br.com.contmatic.constants.Messages;

public class DateUtils {
	
	public DateUtils() {
		throw new IllegalArgumentException(Messages.NAO_INSTANCIAVEL);
	}
	
	public static Integer getIdade(LocalDate dataNascimento) {
		if ((dataNascimento != null)) {
            return Period.between(dataNascimento, LocalDate.now()).getYears();
        } else {
            return 0;
        }
	}

}
