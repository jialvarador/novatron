package org.sii.core.utility;

import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {

	private static final Logger log = LoggerFactory.getLogger(Utilities.class);

	public static boolean isNumeric(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	/**
	 * 
	 * @param word
	 * @return Expresion regular "(\\d){1,10}\\.(\\d){1,10}" (\\d)digito {1,10}de 1
	 *         a 10 caracteres \\. punto
	 * 
	 */
	public static boolean isDecimal(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("(\\d){1,8}\\.(\\d){0,2}");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
		// DoubleValidator doubleValidator = new DoubleValidator();
		// return doubleValidator.isValid(word);
	}

	public static boolean checkWordAndCheckWithlength(String word, Integer length) {
		boolean ret = false;
		if (word.length() <= length) {
			ret = true;
		}
		return ret;
	}

	public static boolean isOnlyLetters(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^A-Za-z0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	/**
	 * Método para valida emails
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @version 2018/01/17
	 * @param sEmail el email a verificar
	 * @return true si es un email válido, false en caso que no sea así.
	 */
	@SuppressWarnings("unused")
	public static boolean isValidEmail(String sEmail) {
		boolean isValid = false;

		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pat = Pattern.compile(EMAIL_PATTERN);
		Matcher mat = pat.matcher(sEmail);
		if (pat.matcher(sEmail).matches()) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param lblName
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public static String errorComponentLogic(String lblName, Locale locale) throws Exception {
		InputStream is = null;
		is = Utilities.class.getResourceAsStream("/i18n/messages_" + locale.getLanguage() + ".properties");

		String exception = "";
		Properties p = new Properties();
		p.load(is);
		exception = p.getProperty(lblName);
		return exception;
	}

	/**
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param lblName
	 * @param locale
	 * @param params
	 * @return {@code String }
	 * @throws Exception
	 */
	public static String errorComponentLogic(String lblName, Locale locale, String... params) throws Exception {
		InputStream is = null;
		is = Utilities.class.getResourceAsStream("/i18n/messages_" + locale.getLanguage() + ".properties");

		String exception = "";
		Properties p = new Properties();
		p.load(is);
		exception = p.getProperty(lblName);

		if (exception != null && params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				exception = exception.replaceAll("\\$" + (i + 1), params[i]);
			}
		}

		return exception;
	}

	public static String generarToken() throws NoSuchAlgorithmException {
		String token = UUID.randomUUID().toString();
		return token;
	}

	/**
	 * Retorna una fecha inicial con horas, minutos y segundos: 00:00:00
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param date
	 * @return Date
	 * @throws Exception
	 */
	public static Date buildStartDate(Date date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * Retorna una fecha final con horas, minutos y segundos: 23:59:59
	 *
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @param date
	 * @return Date
	 * @throws Exception
	 */
	public static Date buildFinalDate(Date date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * Funcíón para redondear un número double a los decimales que le ingresen
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @since 1.8
	 * @param numero
	 * @param decimales
	 * @return
	 *
	 */
	public static double redondear(double numero, int decimales) {
		boolean negativo = false;
		if (numero < 0) {
			numero *= -1;
			negativo = true;
		}
		double redondeado = Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
		return negativo ? redondeado * -1 : redondeado;
	}

	/**
	 * Función para obtener el número que sea múltiplo de "multiploDe" y mayor que
	 * "mayorQue"
	 * 
	 * @author Jose Inocencio Alvarado
	 * @date Oct 27, 2017
	 * @since 1.8
	 * @param multiploDe
	 * @param mayorQue
	 * @return
	 *
	 */
	public static Integer siguienteMultiploMayorOIgual(Integer multiploDe, Integer mayorQue) {
		Double division = mayorQue.doubleValue() / multiploDe.doubleValue();
		division = (Math.ceil(division));
		Integer numeroSiguiente = division.intValue() * multiploDe;
		return numeroSiguiente;
	}

}