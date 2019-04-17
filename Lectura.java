package xyz.germanfica.util;

import java.util.Scanner;

public class Lectura {
	public static int leerOpcion() {
		int opcion;
		Scanner sc = new Scanner(System.in);
		opcion = sc.nextInt();
		
		return opcion;
	}
}
