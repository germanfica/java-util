package xyz.germanfica.util;

/**
 * Esta clase contiene utilidades para el manejo de arreglos
 * de caracteres.
 * 
 * @author German Fica - {@link germanfica.xyz}
 */
public class ArregloCaracter {
	/**
	 * Cuenta cuantas veces se repite un caracter dado
	 * 
	 * @param caracteres es el arreglo de caracteres
	 * @param c          es el caracter que vamos a usar para saber si se repite en
	 *                   el arreglo
	 * @return La cantidad de veces que se ha repetido ese caracter
	 */
	public static int esteCaracterSeRepite(char[] caracteres, char c) {
		int cant;
		cant = 0;
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i] == c)
				cant++;
		}
		return cant;
	}
	
	public static void mostrarEsteCaracterSeRepite(char[] caracteres, char c) {
		System.out.println(esteCaracterSeRepite(caracteres, c));
	}

	/**
	 * Mostrar los caracteres de posición par del arreglo
	 * 
	 * @param caracteres es el arreglo de caracteres
	 */
	public static void mostrarPosPar(char[] caracteres) {
		for (int i = 0; i < caracteres.length; i++) {
			if (NumeroEntero.esPar(i)) {
				System.out.println(caracteres[i]);
			}
		}
	}

	/**
	 * En este modulo voy a mostrar los caracteres del arreglo de caracteres
	 * 
	 * @param caracteres es el arreglo de caracteres
	 */
	public static void mostrar(char[] caracteres) {
		for (int i = 0; i < caracteres.length; i++) {
			System.out.println(caracteres[i]);
		}
	}

	/**
	 * Genera un nuevo arreglo con el orden de los elementos invertidos al del
	 * arreglo por parametro
	 * 
	 * @param caracteres es el arreglo de caracteres
	 * @return Arreglo de caracteres pero ahora con el orden de los elementos
	 *         invertidos
	 */
	public static char[] ordInvertido(char[] caracteres) {
		char[] nuevoArreglo;
		int longitud, aux;

		longitud = caracteres.length;
		nuevoArreglo = new char[longitud];
		aux = longitud - 1;

		for (int i = 0; i < longitud; i++) {
			nuevoArreglo[i] = caracteres[aux];
			aux--;
		}

		return nuevoArreglo;
	}

	/**
	 * Mostrar por pantalla los caracteres almacenados en el arreglo en orden
	 * inverso
	 * 
	 * @param caracteres es el arreglo de caracteres a mostrar
	 */
	public static void mostrarOrdInvertido(char[] caracteres) {
		ArregloCaracter.mostrar(ArregloCaracter.ordInvertido(caracteres));
	}
}
