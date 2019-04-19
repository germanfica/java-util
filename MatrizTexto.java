package xyz.germanfica.util;

import java.util.Scanner;

public class MatrizTexto {
	private static Scanner scCargaFilaDesdeArchivo;
	private static Scanner scCargaDesdeArchivo;
	
	/*
	 * Muestra todos los elementos de una matriz de texto
	 * seperados con un espacio
	 */
	public static void mostrarConEspacio(String[][] matrizTexto) {
		// Declaraci�n de variables
		int cantFilas, cantColumnas;
		
		// Inicializaic�n de variables
		cantFilas = matrizTexto.length;
		cantColumnas = matrizTexto[0].length;
		for (int i = 0; i <= cantFilas-1; i++) {
			for (int j = 0; j <= cantColumnas-1; j++) {
				System.out.print(matrizTexto[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	/*
	 * Se requiere para el m�dulo 'cargaDesdeArchivo(ARCHIVO)'.
	 */
	private static String[] cargaFilaDesdeArchivo(String contenidoFila, int cantColumnas) {
		// Declaraci�n de variables
		String[] arreglo;
		int j;
		
		// Inicializaci�n de variables
		arreglo = new String[cantColumnas];
		j=0;
		
		// Carga de elementos
		scCargaFilaDesdeArchivo = new Scanner(contenidoFila); // Le digo al scanner que me analice el contenido del archivo
		scCargaFilaDesdeArchivo.useDelimiter("\\s*,\\s*"); // Clasifica los elementos cuando encuntra un punto y coma
		
		while(scCargaFilaDesdeArchivo.hasNext()) {
			arreglo[j] = scCargaFilaDesdeArchivo.next();
			j++;
		}
		return arreglo;
	}
	
	/**
	 * Carga una matriz de texto desde un archivo solicitado.
	 * 
	 * Este m�dulo solo funciona si cumple con el siguiente formato:
	 * Los elementos de cada fila deben ir separados con una ','. 
	 * Al final de cada columna debe terminar con un ';'.
	 *  
	 * Ejemplo:
	 * Fila 0: 0,a,b,c,5,r;
	 * Fila 1: 0,3,9,t,5,z;
	 * Fila 2: f,5,5,3,2,d;
	 * 
	 * Si existe una fila con mayor cantidad de elementos que
	 * las demas, la dimension de las filas ser� de dicha dimensi�n,
	 * es decir la de mayor cantidad de elementos. El valor de los
	 * elementos no asignados es por defecto ''.
	 * 
	 * @param ARCHIVO ruta del archivo. Ac� no va el contenido del archivo.
	 * Para obtener el contenido del archivo s�lo basta con llamar al m�dulo
	 * Archivo.Leer(ARCHIVO), siendo ARCHIVO (la ruta)+(nombre del
	 * archivo con su extensi�n), ejemplo: 
	 * ARCHIVO = "src/xyz/germanfica/ad/_2018/_2nd/tp3/Ej2.txt".
	 * @return Devuelve una matriz de texto cargada con los elementos
	 * del archivo.
	 */
	public static String[][] cargaDesdeArchivo(String ARCHIVO) {
		// Declaraci�n de variables
		String[][] matrizTexto;
		int[] dimensiones;
		int cantFilas, cantColumnas, i;
		String contenidoDelArchivo, contenidoFila;
		
		// Inicializaci�n de variables
		contenidoDelArchivo = Archivo.leer(ARCHIVO).getTexto();
		dimensiones = Matriz.dimensionesArchivo(contenidoDelArchivo);// Llamar al m�dulo que determina la cantidad de filas y columnas de la matriz del archivo
		cantFilas = dimensiones[0];
		cantColumnas = dimensiones[1];
		matrizTexto = new String[cantFilas][cantColumnas];
		i = 0;
		
		// Carga de elementos
		
		scCargaDesdeArchivo = new Scanner(contenidoDelArchivo); // Le digo al scanner que me analice el contenido del archivo
		scCargaDesdeArchivo.useDelimiter("\\s*;\\s*"); // Clasifica los elementos cuando encuntra un punto y coma
		
		while(scCargaDesdeArchivo.hasNext()) {
			contenidoFila = scCargaDesdeArchivo.next();
			matrizTexto[i] = cargaFilaDesdeArchivo(contenidoFila, cantColumnas);
			i++;
		}
		return matrizTexto;
	}
}
