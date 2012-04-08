package util.conversores;

public class StringUtil {
	
	/**
	 * Preenche uma string com um dado caracter ate que esta venha a ter o tamanho desejado
	 * @param string 
	 * @param tamanho tamanho desejado
	 * @param caracter caracter utilizado no preenchimento
	 */
	public static String padLeft(final String string, final int tamanho, final char caracter) {
		final StringBuilder result = new StringBuilder(tamanho);
		for (int i = string.length(); i < tamanho; i++)
			result.append(caracter);
		result.append(string);
		return result.toString();
	}

	/**
	 * Preenche uma string com um dado caracter ate que esta venha a ter o tamanho desejado
	 * @param string 
	 * @param tamanho tamanho desejado
	 * @param caracter caracter utilizado no preenchimento
	 */
	public static String padRight(final String string, final int tamanho, final char caracter) {
		final StringBuilder result = new StringBuilder(tamanho);
		result.append(string);
		for (int i = string.length(); i < tamanho; i++)
			result.append(caracter);
		return result.toString();
	}
}
