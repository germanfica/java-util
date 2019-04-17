package xyz.germanfica.util;

import java.util.Scanner;

/**
 * Esta clase contiene utilidades para el manejo de matrices
 * de enteros.
 * 
 * @author German Fica - {@link germanfica.xyz}
 */
public class MatrizEntero {
	private static Scanner sc; // Este Scanner solo se va a encargar de manejar las entradas del sistema.
	private static Scanner scCargaFilaDesdeArchivo;
	private static Scanner scCargaDesdeArchivo;
	
	/**
	 * Para poder definir AB es necesario que el número de
	 * columnas de la primera matriz coincida con el número
	 * de filas de la segunda matriz.
	 * 
	 * @param matrizA es la matriz A de enteros.
	 * @param matrizB es la matriz B de enteros.
	 * @return Devuelve la matriz producto.
	 */
	public static int[][] producto(int[][] matrizA, int[][] matrizB) {
		// Declaración de variables
		int[][] matrizProducto;
		int cantFilasNuevaMatriz, cantColumnasNuevaMatriz, cantFilasMatrizA, cantColumnasMatrizA, cantFilasMatrizB, cantColumnasMatrizB;
		
		// Inicialización de variables
		cantFilasNuevaMatriz = matrizA.length; // Cantidad de filas de la nueva matriz
		cantColumnasNuevaMatriz = matrizB[0].length; // Cantidad de columnas de la nueva matriz
		cantFilasMatrizA = matrizA.length; // Cantidad de filas de la Matriz A
		cantColumnasMatrizA = matrizA[0].length; // Cantidad de columnas de la Matriz A
		cantFilasMatrizB = matrizB.length; // Cantidad de filas de la Matriz B
		cantColumnasMatrizB = matrizB[0].length; // Cantidad de columnas de la Matriz B
		matrizProducto = new int[cantFilasNuevaMatriz][cantColumnasNuevaMatriz];
		
		// Hacer el producto
		int elem, suma;
		suma=0;
		
		if(cantColumnasMatrizA==cantFilasMatrizB) {
			// Filas de la primera matriz
			for (int i = 0; i < cantFilasMatrizA; i++) {
				for (int j = 0; j < cantColumnasMatrizA; j++) {
					//elem=matrizA[1][i]*matrizB[i][1];
					//suma+=elem;
					//System.out.println(matrizA[i][j]);
				}
			}
			
			System.out.println("___________");
			
			// Columnas de la segunda matriz
			for (int i = 0; i < cantColumnasMatrizB; i++) {
				for (int j = 0; j < cantFilasMatrizB; j++) {
					//System.out.println(matrizB[j][i]);
					for (int k = 0; k < cantColumnasMatrizA; k++) { // cantColumnasMatrizA
	                    System.out.println(matrizA[i][k]);
	                }
				}
			}
			
			for (int k = 0; k <= matrizA[0].length-1; k++) {
				//System.out.println(k);
			}
			
			for (int i = 0; i < cantFilasMatrizA; i++) { // cantFilasMatrizA
	            for (int j = 0; j < cantColumnasMatrizB; j++) { // cantColumnasMatrizB
	                for (int k = 0; k < cantColumnasMatrizA; k++) { // cantColumnasMatrizA
	                	matrizProducto[i][j] += matrizA[i][k] * matrizB[k][j];
	                }
	            }
	        }
			
		}else {
			System.err.println("El número de columnas de la primera matriz no coincide con el número de filas de la segunda matriz.");
			System.exit(0);
		}
		return matrizProducto;
	}
	
	/**
	 * Determina si dos matrices tienen el mismo órden.
	 * 
	 * @param matrizA es la primera matriz.
	 * @param matrizB es la segunda matriz.
	 * @return Devuelve verdadero si coinciden los órdenes de las matrices
	 * ingresadas sino falso.
	 */
	public static boolean mismoOrden(int[][] matrizA, int[][] matrizB) {
		return matrizA.length==matrizB.length && matrizA[0].length==matrizB[0].length;
	}
	
	/**
	 * Suma de dos matrices. Si los órdens de las matrices
	 * no coinciden entonces no se aplica la suma.
	 * 
	 * @param matrizA es la primera matriz.
	 * @param matrizB es la segunda matriz.
	 * @return Devuelve la matriz suma.
	 */
	public static int[][] suma(int[][] matrizA, int[][] matrizB) {
		// Declaración de variables
		int[][] nuevaMatriz;
		int cantFilas, cantColumnas;
		
		// Inicialización de variables
		cantFilas = matrizA.length;
		cantColumnas = matrizA[0].length;
		nuevaMatriz = new int[cantFilas][cantColumnas]; // No te preocupes, sé lo que pensas. Si los órdens de las matrices no coinciden entonces no se aplica la suma. Luego retorna una matriz nula.
		
		// Suma
		if(mismoOrden(matrizA, matrizB)) {
			for (int i = 0; i <= cantFilas-1; i++) {
				for (int j = 0; j <= cantColumnas-1; j++) {
					nuevaMatriz[i][j]=matrizA[i][j] + matrizB[i][j];
					System.out.println(nuevaMatriz[i][j]);
				}
			}
		}else {
			System.err.println("No coinciden los órdenes de las matrices ingresadas.");
		}
		
		return nuevaMatriz;
	}
	
	/**
	 * Suma los elementos de una columna determinada
	 * de una matriz de enteros.
	 * 
	 * @param matriz es la matriz de enteros.
	 * @param columna es la columna para hacer la suma.
	 * @return Devuelve la suma de la columna escogida.
	 */
	public static int sumaColumna(int[][] matriz, int columna) {
		// Declaración de variables
		int suma, cantFilas;
		
		// Inicialización de variables
		cantFilas = matriz.length;
		suma = 0;
		
		// Hacer la suma
		for (int i = 0; i <= cantFilas-1; i++) {
			suma+=matriz[i][columna];
		}
		
		return suma;
	}
	
	/**
	 * Suma los elementos de una fila determinada
	 * de una matriz de enteros.
	 * 
	 * @param matriz es la matriz de enteros.
	 * @param fila es la fila para hacer la suma.
	 * @return Devuelve la suma de la fila escogida.
	 */
	public static int sumaFila(int[][] matriz, int fila) {
		// Declaración de variables
		int suma, cantColumnas;
		
		// Inicialización de variables
		cantColumnas = matriz[0].length;
		suma = 0;
		
		// Hacer la suma
		for (int j = 0; j <= cantColumnas-1; j++) {
			suma+=matriz[fila][j];
		}
		
		return suma;
	}
	
	/**
	 *<dl>
	 *<dt><span>Description:</span></dt>
	 *Traspone una matriz de enteros.
	 *<dt><span>Example:</span></dt>
	 *<div style="border: 1px solid #dddddd; border-radius: 5px;">
	 *<pre style="margin: 10px 10px 10px 10px;"><b><font color="#9933ff">import</font></b> xyz.germanfica.util.MatrizEntero;
	 *
	 *<b><font color="#9933ff">public class</font></b> Ejemplo {
	 *    <b><font color="#9933ff">public static void</font></b> main(String[] args) {
	 *        <font color="#339933">// Declaración de variables</font>
	 *        <b><font color="#9933ff">int[][]</font></b> matrizTraspuesta;
	 *
	 *        <font color="#339933">// Inicialización de variables</font>
	 *        <b><font color="#9933ff">int[][]</font></b> matriz = {{-1,2,5},{-2,3,7}};
	 *
	 *        <font color="#339933">// Transponemos la matriz</font>
	 *        matrizTraspuesta = MatrizEntero.trasponer(matriz);
	 *
	 *        <font color="#339933">// Mostramos la matriz transpuesta</font>
	 *        {@link xyz.germanfica.util.MatrizEntero#mostrar(int[][]) MatrizEntero.mostrar}(matrizTraspuesta);
	 *    }
	 *}</pre></div></dl>
	 *@param matriz es la matriz de enteros que se quiere trasponer.
	 *@return Devuelve la matriz traspuesta.
	 */
	public static int[][] trasponer(int[][] matriz) {
		// Declaración de variables
		int[][] nuevaMatriz;
		int cantFilas, cantColumnas;
		
		// Inicialización de variables
		cantFilas = matriz[0].length; // Cantidad de filas de la matriz traspuesta
		cantColumnas = matriz.length; // Cantidad de columnas de la matriz transpuesta
		nuevaMatriz = new int[cantFilas][cantColumnas];
		
		// Trasponer
		for (int i = 0; i <=cantFilas-1; i++) {
			for (int j = 0; j <=cantColumnas-1; j++) {
				nuevaMatriz[i][j] = matriz[j][i];
			}
		}
		return nuevaMatriz;
	}
	
	/**
	 * Determina el producto por un escalar de una matriz.
	 * 
	 * @param matriz es la matriz de enteros.
	 * @param escalar es el escalar.
	 * @return Devuelve la matriz completa.
	 */
	public static int[][] productoPorUnEscalar(int[][] matriz, int escalar) {
		// Declaración de variables
		int[][] nuevaMatriz;
		int cantFilas, cantColumnas;
		
		// Inicialización de variables
		cantFilas = matriz.length;
		cantColumnas = matriz[0].length;
		nuevaMatriz = new int[cantFilas][cantColumnas];
		
		// Resolver el producto por un escalar
		for (int i = 0; i <= cantFilas-1; i++) {
			for (int j = 0; j <= cantColumnas-1; j++) {
				nuevaMatriz[i][j] = matriz[i][j]*escalar;
				System.out.println(nuevaMatriz[i][j]);
			}
		}
		
		return nuevaMatriz;
	}
	
	/**
	 * Determina si una matriz de enteros es diagonal.
	 * 
	 * @param matriz es la matriz de enteros.
	 * @return Devuelve verdadero si la matriz de enteros es
	 * diagonal.
	 */
	public static boolean esDiagonal(int[][] matriz) {
		return esTriangularSuperior(matriz) && esTriangularInferior(matriz);
	}
	
	/**
	 * Determina si una matriz de enteros es triangular inferior.
	 * 
	 * @param matriz es la matriz de enteros.
	 * @return Devuelve verdadero si la matriz de enteros es
	 * triangular inferior.
	 */
	public static boolean esTriangularInferior(int[][] matriz) {
		// Declaración de variables
		int cantFilas, cantColumnas, i, j;
		boolean esTriangularSuperior;
		
		// Inicialización de variables
		cantFilas = matriz.length;
		cantColumnas = matriz[0].length;
		esTriangularSuperior = false;
		i=0;
		j=0;
		
		// Es una matriz cuadrada?
		if(Matriz.esCuadrada(cantFilas, cantColumnas)) {
			esTriangularSuperior = true; // Posiblemente sea triangular superior
			// Determina si es triangular superior
			while(i<= cantFilas-1 && esTriangularSuperior) {
				j = 0; // Reiniciar el j
				while(j <= cantColumnas-1 && esTriangularSuperior) {
					if(i<j && matriz[i][j]!=0) {
						esTriangularSuperior = false;
					}
					j++;
				}
				i++;
			}
		}
		return esTriangularSuperior;
	}
	
	/**
	 * Determina si una matriz de enteros es triangular superior.
	 * 
	 * @param matriz es la matriz de enteros.
	 * @return Devuelve verdadero si la matriz de enteros es
	 * triangular superior.
	 */
	public static boolean esTriangularSuperior(int[][] matriz) {
		// Declaración de variables
		int cantFilas, cantColumnas, i, j;
		boolean esTriangularSuperior;
		
		// Inicialización de variables
		cantFilas = matriz.length;
		cantColumnas = matriz[0].length;
		esTriangularSuperior = false;
		i=0;
		j=0;
		
		// Es una matriz cuadrada?
		if(Matriz.esCuadrada(cantFilas, cantColumnas)) {
			esTriangularSuperior = true; // Posiblemente sea triangular superior
			// Determina si es triangular superior
			while(i<= cantFilas-1 && esTriangularSuperior) {
				j = 0; // Reiniciar el j
				while(j <= cantColumnas-1 && esTriangularSuperior) {
					if(i>j && matriz[i][j]!=0) {
						esTriangularSuperior = false;
					}
					j++;
				}
				i++;
			}
		}
		return esTriangularSuperior;
	}
	
	/**
	 * Muestra todos los elementos de una matriz de enteros.
	 * 
	 * @param matriz es la matriz que se quiere mostrar por pantalla.
	 */
	public static void mostrar(int[][] matriz) {
		// Declaración de variables
		int cantFilas, cantColumnas;
		
		// Inicializaicón de variables
		cantFilas = matriz.length;
		cantColumnas = matriz[0].length;
		for (int i = 0; i <= cantFilas-1; i++) {
			for (int j = 0; j <= cantColumnas-1; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * Se requiere para el módulo 'cargaDesdeArchivo(ARCHIVO)'.
	 */
	private static int[] cargaFilaDesdeArchivo(String contenidoFila, int cantColumnas) {
		// Declaración de variables
		int[] arreglo;
		int j;
		
		// Inicialización de variables
		arreglo = new int[cantColumnas];
		j=0;
		
		// Carga de elementos
		scCargaFilaDesdeArchivo = new Scanner(contenidoFila); // Le digo al scanner que me analice el contenido del archivo
		scCargaFilaDesdeArchivo.useDelimiter("\\s*,\\s*"); // Clasifica los elementos cuando encuntra un punto y coma
		
		while(scCargaFilaDesdeArchivo.hasNext()) {
			try {
				arreglo[j] = scCargaFilaDesdeArchivo.nextInt();
				j++;
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Porfavor borre los caracteres que son letras. Sólo se permiten números.");
				System.exit(0); // Forzar a salir del programa
			}
			
		}
		return arreglo;
	}
	
	/**
	 * Carga una matriz de enteros desde un archivo solicitado.
	 * 
	 * Este módulo solo funciona si cumple con el siguiente formato:
	 * Los elementos de cada fila deben ir separados con una ','. 
	 * Al final de cada columna debe terminar con un ';'.
	 *  
	 * Ejemplo:
	 * Fila 0: 0,2,3,4,5,8;
	 * Fila 1: 0,2,3,4,5,8;
	 * Fila 2: 1,2,2,3,2,8;
	 * 
	 * Si existe una fila con mayor cantidad de elementos que
	 * las demas, la dimension de las filas será de dicha dimensión,
	 * es decir la de mayor cantidad de elementos. El valor de los
	 * elementos no asignados es por defecto 0.
	 * 
	 * @param ARCHIVO ruta del archivo. Acá no va el contenido del archivo.
	 * Para obtener el contenido del archivo sólo basta con llamar al módulo
	 * Archivo.Leer(ARCHIVO), siendo ARCHIVO (la ruta)+(nombre del
	 * archivo con su extensión), ejemplo: 
	 * ARCHIVO = "src/xyz/germanfica/ad/_2018/_2nd/tp3/Ej2.txt".
	 * @return Devuelve una matriz de enteros cargada con los elementos
	 * del archivo.
	 */
	public static int[][] cargaDesdeArchivo(String ARCHIVO) {
		// Declaración de variables
		int[][] enteros;
		int[] dimensiones;
		int cantFilas, cantColumnas, i;
		String contenidoDelArchivo, contenidoFila;
		
		// Inicialización de variables
		contenidoDelArchivo = Archivo.leer(ARCHIVO);
		dimensiones = Matriz.dimensionesArchivo(contenidoDelArchivo);// Llamar al módulo que determina la cantidad de filas y columnas de la matriz del archivo
		cantFilas = dimensiones[0];
		cantColumnas = dimensiones[1];
		enteros = new int[cantFilas][cantColumnas];
		i = 0;
		
		// Carga de elementos
		
		scCargaDesdeArchivo = new Scanner(contenidoDelArchivo); // Le digo al scanner que me analice el contenido del archivo
		scCargaDesdeArchivo.useDelimiter("\\s*;\\s*"); // Clasifica los elementos cuando encuntra un punto y coma
		
		while(scCargaDesdeArchivo.hasNext()) {
			contenidoFila = scCargaDesdeArchivo.next();
			enteros[i] = cargaFilaDesdeArchivo(contenidoFila, cantColumnas);
			i++;
		}
		return enteros;
	}
	
	/**
	 * Lee la cantidad de filas y cantidad de columnas para una
	 * matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas.
	 * 
	 * @param primerMensaje este es el mensaje que se mostraria cuando se ingresa
	 * la cantidad de filas.
	 * @param segundoMensaje este es el mensaje que se mostraria cuando se ingresa
	 * la cantidad de columnas.
	 * @return Devuelve la cantidad de filas y cantidad de columnas.
	 */
	public static int[] dimensiones(String primerMensaje, String segundoMensaje) {
		// Declaracion de variables
		int[] dimensiones;
		
		// Inicializacion de variables
		dimensiones = new int[2]; // Creacion de la matriz
		
		sc = new Scanner(System.in);
		System.out.println(primerMensaje);
		dimensiones[0] = sc.nextInt(); // Lee la cantidad de filas
		System.out.println(segundoMensaje);
		dimensiones[1] = sc.nextInt(); // Lee la cantidad de columnas
		return dimensiones;
	}
	
	/**
	 * Lee la cantidad de filas y cantidad de columnas para una
	 * matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas.
	 * 
	 * @return Devuelve la cantidad de filas y cantidad de columnas.
	 */
	public static int[] dimensiones() {
		return dimensiones("", "");
	}
	
	public static int[][] cargaCompleta(int[] dimensiones, String mensaje) {
		// Declaracion de variables
		int[][] matrizEnteros;
		int cantFilas, cantColumnas;
		
		// Inicializacion de variables
		cantFilas = dimensiones[0]; // Cantidad de filas
		cantColumnas = dimensiones[1]; // Cantidad de columnas
		matrizEnteros = new int[cantFilas][cantColumnas];
		
		// Carga de elementos
		for (int i = 0; i <= cantFilas-1; i++) {
			//System.out.print("Fila " + i + ". "); // Estaba depurando
			matrizEnteros[i] = cargaFila(dimensiones, i, mensaje)[i]; // Carga la fila i de elementos
		}
		
		return matrizEnteros;
	}
	
	/**
	 * Carga de de n elementos la fila i-esima a una matriz
	 * de enteros.
	 * 
	 * @param dimensiones representa la cantidad de filas y cantidad de
	 * columnas para la matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas.
	 * @param fila es la fila i-esima a la que se le aplica la carga de elementos
	 * @param mensaje es el mensaje que se muestra cada vez que se le
	 * pide al usuario agregar un nuevo elemento a la matriz.
	 * @return Devuelve una matriz de enteros cargada de n enteros en la fila i-esima.
	 */
	public static int[][] cargaFila(int[] dimensiones, int fila, String mensaje) {
		// Declaracion de variables
		int[][] matrizEnteros;
		int num, cantFilas, cantColumnas;

		// Inicializacion de variables
		cantFilas = dimensiones[0];
		cantColumnas = dimensiones[1];
		matrizEnteros = new int[cantFilas][cantColumnas];

		// Agrega elementos a la matriz
		for (int i = 0; i <= cantColumnas - 1; i++) {
			System.out.println(mensaje);
			sc = new Scanner(System.in);
			num = sc.nextInt();
			matrizEnteros[fila][i] = num;
		}
		return matrizEnteros;
	}
	
	/**
	 * Carga de de n elementos la fila i-esima a una matriz
	 * de enteros.
	 * 
	 * @param dimensiones representa la cantidad de filas y cantidad de
	 * columnas para la matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas.
	 * @param fila es la fila i-esima a la que se le aplica la carga de elementos.
	 * @return Devuelve una matriz de enteros cargada de n enteros en la fila i-esima.
	 */
	public static int[][] cargaFila(int[] dimensiones, int fila) {
		return cargaFila(dimensiones,fila,"");
	}
}
