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
	public static String leer(String NOMBRE_ARCHIVO) {
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
		
		return contenido;
	}
	
	/**
	 * Leer el contenido de un archivo determinado.
	 * 
	 * @param NOMBRE_ARCHIVO ruta completa del archivo
	 * @param conEspacio mantener los espacios del archivo
	 * @return texto plano con espacios del contenido del archivo solicitado
	 */
	public static String leer(String NOMBRE_ARCHIVO, boolean conEspacio) {
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
		
		return contenido;
	}
}
