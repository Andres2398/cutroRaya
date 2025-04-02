package vista;

import java.util.Scanner;

import modelo.Tablero;

public class Interfaz {
	private Scanner sc;
	private Tupla tupla;
	private String comentario;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Interfaz() {
		tupla = new Tupla();
		comentario = "";
	}

	/**
	 * Funcion para mostrar el tablero jugador 1 seran las X y 2 seran los 0
	 * 
	 * @param tablero
	 */
	private void mostrarTablero(Tablero tablero) {
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				if (tablero.getTablero()[i][j] == 0) {
					System.out.print("[ ]");
				} else if (tablero.getTablero()[i][j] == 1) {
					System.out.print("[X]");
				} else
					System.out.print("[0]");
			}
			System.out.println();
		}

	}

	/**
	 * Pedirle a cada jugador la columna a la que quiere disparar
	 * 
	 * @param jugador
	 * @param tablero
	 * @return
	 */
	public int pedirColumna(boolean jugador, Tablero tablero) {
		mostrarTablero(tablero);
		boolean correcto = false;
		String caracteres;
		sc = new Scanner(System.in);
		if (jugador)
			System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
		else
			System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");
		caracteres = sc.nextLine();
		comprobarCaracteres(caracteres, jugador);
		correcto = tupla.isBuena();

		while (!correcto) {
			System.out.println("Has introducido un caracter invalido, recuerda solo numeros enteros entre 0 y 6");
			if (jugador)
				System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
			else
				System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");

			caracteres = sc.nextLine();
			comprobarCaracteres(caracteres, jugador);
			correcto = tupla.isBuena();

		}

		return tupla.getColumna();
	}

	/*
	 * Comprobar si la columna que elige el usuario esta en el juego y en caso de
	 * que no pedirle otra
	 */
	private boolean comprobarColumna(int columna) {
		if (columna >= 0 && columna <= 6)
			return true;
		else
			return false;

	}

	/*
	 * En caso de que la columna este llena se le pedira al jugador de nuevo otra
	 * columna
	 */
	public void comprobarCaracteres(String caracteres, boolean jugador) {

		char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		int correcto = 0;
		int columna = 0;
		int multiplicar = 1;
		boolean permitido = false;

		for (int i = caracteres.length() - 1; i >= 0; i--) {
			permitido = false;
			for (int j = 0; j < numeros.length; j++) {
				if (caracteres.charAt(i) == numeros[j]) {
					correcto++;
					permitido = true;

				}

			}

			if (permitido) {
				columna += caracteres.charAt(i) - '0' * multiplicar;
				multiplicar *= 10;

			}

		}

		if (correcto == caracteres.length()) {
			tupla.setColumna(columna);
			tupla.setBuena(comprobarColumna(columna));

		} else
			tupla.setBuena(false);

	}

	public int pedirNuevo(boolean jugador, Tablero tablero) {

		if (jugador)
			System.out.println("Jugador 1, no se ha podidio colocar la ficha en esa columna intenta otra");
		else
			System.out.println("Jugador 2, no se ha podido colocar la ficha en esa columna intenta otra");
		pedirColumna(jugador, tablero);
		return tupla.getColumna();
	}

	public void tableroGanador(Tablero tablero, boolean jugador) {
		jugador = !jugador;
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				if (tablero.getTablero()[i][j] == 0) {
					System.out.print("[ ]");
				} else if (tablero.getTablero()[i][j] == 1) {
					System.out.print("[X]");
				} else
					System.out.print("[0]");
			}
			System.out.println();
		}
		if (jugador == true)
			System.out.println("Felicidades ha ganado el jugador 1");
		else
			System.out.println("Felicidades ha ganado el jugador 2");

	}

}
