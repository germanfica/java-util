package xyz.germanfica.util;

import java.util.Scanner;

/**
 * Esta clase contiene utilidades para el manejo de arreglos
 * de palabras.
 * 
 * @author German Fica - {@link germanfica.xyz}
 */
public class ArregloPalabra {
	private static Scanner sc;
	
	/**
	 * En este modulo voy a mostrar las palabras del arreglo de palabras
	 * 
	 * @param palabras es el arreglo de palabras
	 */
	public static void mostrar(String[] palabras) {
		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i]);
		}
	}
	
	/**
	 * Carga de de n elementos a un arreglo de String
	 * 
	 * @param longitud la longitud del arreglo a cargar
	 * @param mensaje es el mensaje que se muestra cada vez que se le
	 * pide al usuario agregar un nuevo elemento
	 * @return un arreglo de palabras cargado de elementos
	 */
	public static String[] carga(int longitud, String mensaje) {
		// Declaracion de variables
		String[] arregloPalabras;
		String palabra; // Caracter
		int i;

		// Inicializacion de variables
		arregloPalabras = new String[longitud];
		i = 0;

		// Agregar elementos al arreglo
		while (i <= arregloPalabras.length - 1) {
			System.out.println(mensaje);
			sc = new Scanner(System.in);
			palabra = sc.next();
			arregloPalabras[i] = palabra;
			i++;
		}
		return arregloPalabras;
	}
	
	/**
	 * Carga de de n elementos a un arreglo de String
	 * 
	 * @param longitud la longitud del arreglo a cargar
	 * @return un arreglo de palabras cargado de elementos
	 */
	public static String[] carga(int longitud) {
		return carga(longitud,"");
	}
	
	/**
	 * Encontrar en un arreglo de palabras la coincidencia de una
	 * palabra dada sin importar las mayúsculas o minúsculas.
	 * 
	 * @param palabras el arreglo que se quiere analizar.
	 * @param palabra la coincidencia que se quiere encontrar.
	 * @return devuelve la palabra de la posición solicitada.
	 */
	public static int posDeLaPalabra(String[] palabras, String palabra) {
		int pos = -1; 
		for (int i = 0; i < palabras.length; i++) {
			if(palabras[i].equalsIgnoreCase(palabra)) {
				pos = i;
			}
		}
		return pos;
	}
	
}
