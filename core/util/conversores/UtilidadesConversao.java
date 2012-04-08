package util.conversores;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * Classe utilitária para conversoes de dados diversos
 * 
 * @author Pablo Souza
 */
public final class UtilidadesConversao {


	private static final Pattern patternDecimalBR_2Decimais = Pattern.compile("^\\d{1,3}(\\.\\d{3})*(\\,\\d{1,})?$");

	private static final Pattern patternDecimalUS_2Decimais = Pattern.compile("^\\d*[0-9](\\.\\d{1,})?$");

	private static final Locale LOCALE_BR = new Locale("pt","BR");	

	private static final NumberFormat numberFormat = NumberFormat.getInstance(LOCALE_BR);

	static {
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
	}


	/**
	 * Converte uma Date para String <code>locale</code> configurado.
	 * @param date
	 * @return
	 */
	public static String dateComoString(Date date) {
		return getSimpleDateFormat("dd/MM/yyyy").format(date);
	}

	/**
	 * Converte uma Data para o mês em extenso em uma String conforme o <code>locale</code> configurado.
	 * @param date
	 * @return
	 */
	public static String mesExtenso(Date date) {
		return getSimpleDateFormat("MMMMM").format(date);
	}
	
	/**
	 * Converte uma Data para o mês em Inteiro conforme o <code>locale</code> configurado.
	 * @param date
	 * @return 
	 */
	public static Integer mesNumerico(Date date) {
		return Integer.valueOf(getSimpleDateFormat("MM").format(date));
	}	
	
	/**
	 * Converte uma String para Date conforme o <code>locale</code> configurado.
	 * @param string
	 * @return
	 */
	public static Date stringComoDate(String string) throws ParseException {
		return getSimpleDateFormat("dd/MM/yyyy").parse(string);
	}

	/**
	 * Converte uma Hora para String conforme o <code>locale</code> configurado.
	 * @param date
	 * @return
	 */
	public static String horaComoString(Date date) {
		return getSimpleDateFormat("HH:mm").format(date);
	}

	/**
	 * Converte uma String representando um número para o formato brasileiro.
	 * @param valor
	 * @return
	 */
	public static String getFloatAsBRFormat(String valor) {
	    return getFloatAsBRFormat(valor, 2);
	}
	
	/**
	 * Converte uma String representando um número para o formato brasileiro.
	 * @param valor
	 * @param digitos
	 * @return
	 */
	public static String getFloatAsBRFormat(String valor, int digitos) {
		if (valor == null || valor.equals("") || valor == ("0") || valor == ("0.0"))
			valor="0";
		DecimalFormat format = new DecimalFormat("###,###.#####");
		format.setMinimumFractionDigits(digitos);
		format.setMaximumFractionDigits(digitos);
		try {
			valor = format.format(Double.parseDouble(valor));
		} catch (NumberFormatException e) {
			return valor;
		}
		return valor.replaceAll("/\\./gi", "@").replaceAll("/\\,/gi", ".").replaceAll("/\\@/gi", ",");
		 
	}
	/**
	 * Converte uma String representando um numero para o formato americano.
	 * @param valor
	 * @return
	 */
	public static String getFloatAsUSFormat(String valor) {
	    return getFloatAsUSFormat(valor, 2);
	}
	/**
	 * Converte uma String representando um numero para o formato americano.
	 * 
	 * @param valor
	 * @param digitos
	 * @return
	 */
	public static String getFloatAsUSFormat(String valor, int digitos) {
		if ((valor == null) || (valor.equals("")) || (valor.equals("0")) 
				|| (valor.equals("0,0")) || (valor.equals("0,00"))) {
			return digitos==2?"0.00":"0.00000";
		}		
		return valor.replaceAll("\\.", "").replaceAll(",", "\\.");
	}
	
	
	/**
	 * Retorna um CPF formatado. 
	 * @param valor
	 * @return
	 */
	public static String formataCpf(Long valor) {

		if (valor == null)
			return "";

		if (valor.longValue() < 0)
			valor = Long.valueOf(valor.longValue() * (-1));

		String formatado = valor.toString();

		if (formatado.length() > 11)
			return "";

		formatado=StringUtil.padLeft(formatado, 11, '0');

		return formatado.substring(0, 3) + "." + formatado.substring(3, 6)
				+ "." + formatado.substring(6, 9) + "-"
				+ formatado.substring(9, 11);
	}

	/**
	 * Retorna um CNPJ formatado.
	 * @param valor
	 * @return
	 */
	public static String formataCnpj(Long valor) {
		
		if (valor == null)
			return "";

		if (valor.longValue() < 0)
			valor = Long.valueOf(valor.longValue() * (-1));

		String formatado = valor.toString();

		if (formatado.length() > 14)
			return "";

		formatado=StringUtil.padLeft(formatado, 14, '0');
		
		return formatado.substring(0, 2) + "." + formatado.substring(2, 5)
				+ "." + formatado.substring(5, 8) + "/"
				+ formatado.substring(8, 12) + "-"
				+ formatado.substring(12, 14);
	}

	/**
	 * Retorna um CEP formatado.
	 * @param valor
	 * @return
	 */
	public static String formataCEP(Long valor) {

		
		if (valor == null)
			return "";

		if (valor.longValue() < 0)
			valor = Long.valueOf(valor.longValue() * (-1));

		String formatado = valor.toString();

		if (formatado.length() > 8)
			return "";

		formatado=StringUtil.padLeft(formatado, 8, '0');

		return formatado.substring(0, 2) + "." + formatado.substring(2, 5) + "-" + formatado.substring(5, 8);
	}	

	/**
	 * Converte String que representa valor monetario para BigDecimal<br><br>  
	 * @param valor em formato como (<b>10,00</b>) (<b>100,00</b>)(<b>1000,00</b>)(<b>10.000,00</b>)(<b>100.000,00</b>)
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal converteValorMonetario(String valor) throws Exception {

		Locale locale = getLocaleStringMonetaria(valor);
		
		if(locale == null){
			throw new IllegalArgumentException("UtilidadesConversao.converteValorMonetario :: O Valor [" + valor + "] está no formato incorreto.");
		}

		DecimalFormat df = (DecimalFormat) DecimalFormat.getNumberInstance(locale);
		df.setParseBigDecimal(true);
		df.setMaximumFractionDigits(2);
		
		return (BigDecimal) df.parse(valor);
	}

	/**
	 * Retorna o locale (US ou BR) de uma String que representa um valor monetario, como <b>1.000,00</b> ou <b>1000.00</b>
	 * @param valor
	 * @return
	 */
	private static Locale getLocaleStringMonetaria(String valor) {
		
		boolean isBR = patternDecimalBR_2Decimais.matcher(valor).matches();
		boolean isUS = patternDecimalUS_2Decimais.matcher(valor).matches();
		
		Locale locale = null;
		if(isBR){
			locale = LOCALE_BR;
		}
		else if(isUS){
			locale = Locale.US;
		}
		return locale;
	}
	
	
	public static SimpleDateFormat getSimpleDateFormat(String mascara){
		SimpleDateFormat format = new SimpleDateFormat(mascara);
		format.setLenient(false);
		return format;		
	}
}