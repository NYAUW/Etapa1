package br.com.contmatic.utils;

import br.com.contmatic.constants.Messages;

public class EnumUtil {
	
	/********************************************************
	 *                  CONSTRUTORES                        *
	 ********************************************************/

	private EnumUtil() {
	  throw new IllegalStateException(Messages.NAO_INSTANCIAVEL);
	}
	
	public static Object getRandomValue(Object[] values) {
		return (values[Double.valueOf(Math.random() * values.length).intValue()]);
	}

}
