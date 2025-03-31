package vista;

import java.util.Scanner;

import modelo.Tablero;

public class Interfaz {
	private Scanner sc;
	
	/**
	 * Funcion para mostrar el tablero jugador 1 seran las X y 2 seran los 0
	 * @param tablero
	 */
	public void mostrarTablero(Tablero tablero) {
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				if (tablero.getTablero()[i][j] == 0) {
					System.out.print("[ ]");
				} else if (tablero.getTablero()[i][j] == 1) {
					System.out.print("[X]");
				}
				else 
					System.out.print("[0]");
			}
			System.out.println();
		}

	}
	
	
	/**
	 * Pedirle a cada jugador la columna a la que quiere disparar
	 * @param jugador
	 * @return
	 */
	public int pedirColumna(boolean jugador) {

		if (jugador)
			System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
		else
			System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");

		sc = new Scanner(System.in);
		int columna = sc.nextInt();
		columna = comprobarColumna(columna);
		return columna;
	}
	
	
	/*
	 * Comprobar si la columna que elige el usuario esta en el juego y en caso de que no pedirle otra
	 */
	private int comprobarColumna(int columna) {
		sc = new Scanner(System.in);
		while (columna < 0 || columna > 6) {
			System.out.println("Columna incorrecta, introduce una columna entre 0 y 6");
			columna = sc.nextInt();
		}

		return columna;

	}
	/*
	 * En caso de que la columna este llena se le pedira al jugador de nuevo otra columna
	 */

	public int pedirNuevo(boolean jugador) {

		if (jugador)
			System.out.println("Jugador 1, no se ha podidio colocar la ficha en esa columna intenta otra");
		else
			System.out.println("Jugador 2, no se ha podido colocar la ficha en esa columna intenta otra");
		sc = new Scanner(System.in);
		int columna = sc.nextInt();
		columna = comprobarColumna(columna);
		return columna;
	}


	public void tableroGanador(Tablero tablero, boolean jugador) {
		jugador=!jugador;
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				if (tablero.getTablero()[i][j] == 0) {
					System.out.print("[ ]");
				} else if (tablero.getTablero()[i][j] == 1) {
					System.out.print("[X]");
				}
				else 
					System.out.print("[0]");
			}
			System.out.println();
		}
		if(jugador==true)
			System.out.println("Felicidades ha ganado el jugador 1");
		else
			System.out.println("Felicidades ha ganado el jugador 2");
		
		
	}

	
}
