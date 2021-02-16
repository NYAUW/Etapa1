package br.com.contmatic.utils;

import static br.com.contmatic.constants.Messages.NAO_INSTANCIAVEL;

public class EnumUtil {
	
	/********************************************************
	 *                  CONSTRUTORES                        *
	 ********************************************************/

	private EnumUtil() {
	  throw new IllegalStateException(NAO_INSTANCIAVEL);
	}
	
	public static Object getRandomValue(Object[] values) {
		return (values[Double.valueOf(Math.random() * values.length).intValue()]);
	}

}
