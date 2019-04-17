package xyz.germanfica.util;

public class Caracter {
	/**
	 * Devuelve verdadero si un caracter es vocal
	 * @param ch
	 * @return
	 */
	public static boolean esVocal(char ch) {
		switch (Character.toLowerCase(ch)) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		default:
			return false;
		}
	}
}
