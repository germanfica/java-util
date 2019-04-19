package xyz.germanfica.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase contiene todas las utilidades para cargar y guardar
 * una cadena de texto en el disco duro.
 * 
 * @author German Fica - {@link germanfica.xyz}
 */
public class Archivo {
	private static Scanner sc;
	private String texto;
	
	public Archivo(String texto) {
		this.texto = texto;
	}
	
	/**
	 * 
	 * @return devuelve el contenido del archivo
	 */
	public String getTexto() {
		return this.texto;
	}
	
	/**
	 * Determina la cantidad de punto y coma que hay en el archivo
	 * 
	 * @return devuelve la cantidad de punto y coma que hay en el archivo
	 */
	private int getCantidadPuntoComa() {
		// Declaración de variables
		Scanner sc = new Scanner(this.texto); // Le digo al scanner que me analice el texto
		int cantFilas;
		
		// Inicialización de variables
		cantFilas = 0;
		
		// Delimitar búsqueda para el Scanner
		sc.useDelimiter("\\s*;\\s*"); // Busca los punto y coma del texto
		
		
		// Almacenar los elementos uno por uno
		while(sc.hasNext()) {
			sc.next();
			cantFilas++;
		}

		return cantFilas;
	}
	
	/**
	 * Se genera un arreglo de textos apartir de un texto. Nota: como separador
	 * se utiliza el punto y coma.
	 * 
	 * <p><b>Ejemplo</b>:
	 * String texto = "firulais, gonzales, caniche, 2018;firulais, gonzales, caniche, 2018;";
     * 
     * <p>Se puede observar que en la variable texto hay dos elementos. Ya que,
     * cada punto y coma representa un elemento para nuestro arreglo.
     * 
	 * @return devuelve un arreglo de textos
	 */
	public String[] toArray() {
		Scanner sc = new Scanner(this.texto); // Le digo al scanner que me analice el texto
		String[] textos = new String[getCantidadPuntoComa()];
		int i = 0;
		
		// Delimitar búsqueda para el Scanner
		sc.useDelimiter("\\s*;\\s*"); // Busca los punto y coma del texto
		
		
		// Almacenar los elementos uno por uno
		while(sc.hasNext()) {
			textos[i] = sc.next();
			i++;
		}
		
		return textos;
	}
	
	/**
	 * Guarda una cadena de caracteres a un archivo de texto. El contenido
	 * del archivo debe ser un string (cadena de caracteres). Es decir,
	 * es necesario que el contenido sea un texto plano para poder
	 * pasarlo a un archivo.
	 * 
	 * @param contenido texto plano del contenido que se quiere guardar
	 * @param NOMBRE_ARCHIVO ruta completa y nombre del archivo
	 */
	public static void guardar(String contenido, String NOMBRE_ARCHIVO) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(NOMBRE_ARCHIVO);
			bw = new BufferedWriter(fw);
			bw.write(contenido);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace(); // Error al leer o escribir en el archivo
			}
		}
	}
	
	/**
	 * Leer el contenido de un archivo determinado.
	 * 
	 * @param NOMBRE_ARCHIVO ruta completa y nombre del archivo
	 * @return texto plano del contenido del archivo solicitado
	 */
	public static Archivo leer(String NOMBRE_ARCHIVO) {
		String contenido = "";
		
    	try {
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO)); // Obtener los datos que estan en el archivo de texto
    		sc = new Scanner(buff); // Le asigno al scanner la tarea para buscar los colores dentro del archivo de texto
    		
    		// Objetivo: es almacenar los colores uno por uno
    		while(sc.hasNext()) {
    			contenido = contenido + sc.next();
    		}
    		buff.close();
    		sc.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error al leer o escribir en el archivo.");
        }
		
		return new Archivo(contenido);
	}
	
	/**
	 * Leer el contenido de un archivo determinado.
	 * 
	 * @param NOMBRE_ARCHIVO ruta completa del archivo
	 * @param conEspacio mantener los espacios del archivo
	 * @return texto plano con espacios del contenido del archivo solicitado
	 */
	public static Archivo leer(String NOMBRE_ARCHIVO, boolean conEspacio) {
		String contenido = "";
		
    	try {
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO)); // Obtener los datos que estan en el archivo de texto
    		sc = new Scanner(buff); // Le asigno al scanner la tarea para buscar los colores dentro del archivo de texto
    		
    		// Objetivo: es almacenar los colores uno por uno
    		if(conEspacio) {
    			while(sc.hasNext()) {
        			contenido = contenido + sc.next() + " ";
        		}
    		}else {
    			while(sc.hasNext()) {
        			contenido = contenido + sc.next();
        		}
    		}
    		buff.close();
    		sc.close();
    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error al leer o escribir en el archivo.");
        }
		
    	return new Archivo(contenido);
	}
}
