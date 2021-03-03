package br.com.contmatic.validator;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;

import java.time.LocalDate;

public class DateValidator {
	
	public DateValidator() {
		throw new IllegalArgumentException(NAO_INSTANCIAVEL);
	}
	
	public static void isDateGreatherThanToday(LocalDate date) {
		if(date.toEpochDay() > LocalDate.now().toEpochDay()) {
			throw new IllegalArgumentException("Data inválida");
		}
	}

}
