package xyz.germanfica.util;

import java.util.Scanner;

import xyz.germanfica.mensaje.Mensaje;

/**
 * Esta clase contiene utilidades para el manejo de arreglos
 * de letras.
 * 
 * @author German Fica - {@link germanfica.xyz}
 */
public class ArregloLetra {
	private static Scanner sc;

	/**
	 * Este modulo solicita el ingreso de caracteres y retorna un arreglo de
	 * caracteres con los elementos ingresados.
	 * 
	 * @param longitud es la cantidad de elementos que tendra el arreglo
	 * @param mensaje por ejemplo, "ingrese su caracter:"
	 * @return Arreglo de caracteres con los elementos previamente cargados
	 */
	public static char[] carga(int longitud, String mensaje) {
		// Declaracion de variables
		char[] arregloLetras;
		char ch; // Caracter
		int i;

		// Inicializacion de variables
		arregloLetras = new char[longitud];
		i = 0;

		// Agregar elementos al arreglo
		while (i <= arregloLetras.length - 1) {
			System.out.println(mensaje);
			sc = new Scanner(System.in);
			ch = sc.next().charAt(0);
			if (Character.isLetter(ch)) {
				arregloLetras[i] = ch;
				i++;
			} else {
				System.err.println(Mensaje.leer(2));
			}
		}
		return arregloLetras;
	}

	/**
	 * Este modulo solicita el ingreso de caracteres y retorna un arreglo de
	 * caracteres con los elementos ingresados.
	 * 
	 * @param longitud es la longitud para el nuevo arreglo
	 * @return Arreglo de caracteres con los elementos previamente cargados
	 */
	public static char[] cargaLetras(int longitud) {
		return carga(longitud, "");
	}
}
