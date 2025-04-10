package vista;

import java.util.Scanner;

import modelo.Tablero;
/**
 * Clase interfaz que se dedicara a toda la comunicacion con el usuario desde mostrar el tablero a pedir al usuario donde quiere introducir la ficha
 */
public class Interfaz {
	private Scanner sc;
	private Tupla tupla;
	private static final String ROJO = "\u001b[31m"; // codigo para colorear el texto rojo
	private static final String AZUL = "\033[34m"; // codigo para colorear el texto azul
	private static final String RESET = "\u001B[0m";
	private static final String VERDE = "\033[32m";
	/**
	 * Constructor de la clase interfaz donde inicamos un objeto tupla
	 */
	public Interfaz() {
		tupla = new Tupla();

	}

	/**
	 * Funcion para mostrar el tablero jugador 1 seran las X y 2 seran los 0
	 * 
	 * @param tablero
	 * @param fin
	 * @param jugador
	 */
	public void mostrarTablero(Tablero tablero, boolean jugador, boolean fin) {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		for (int i = 0; i < tablero.getColumnas(); i++) {
			System.out.print( VERDE + "   "+(i+1) + "  " + RESET);
		}
		System.out.println();
		System.out.print("╔");
		for (int i = 0; i < tablero.getColumnas(); i++) {
			if (i != tablero.getColumnas() - 1)
				System.out.print("═════╦");
			else
				System.out.print("═════╗");

		}
		System.out.println();

		for (int i = 0; i < tablero.getFilas(); i++) {
			System.out.print("║");
			for (int j = 0; j < tablero.getColumnas(); j++) {
				if (tablero.getTablero()[i][j] == 1)
					System.out.print("  " + AZUL + "■" + RESET + "  ║");
				else if (tablero.getTablero()[i][j] == 2)
					System.out.print("  " + ROJO + "■" + RESET + "  ║");
				else
					System.out.print("  " + " " + "  ║");

			}
			System.out.println();
			if (i < tablero.getFilas() - 1) {
				System.out.print("╠");
				for (int j = 0; j < tablero.getColumnas(); j++) {
					if (j != tablero.getColumnas() - 1)
						System.out.print("═════╬");
					else
						System.out.print("═════╣");
				}
				System.out.println();
			}

		}
		System.out.print("╚");
		for (int i = 0; i < tablero.getColumnas(); i++) {
			if (i != tablero.getColumnas() - 1)
				System.out.print("═════╩");
			else
				System.out.print("═════╝");
		}
		if (fin) {
			System.out.println();
			if (jugador)
				System.out.println(VERDE + "Felicidades ha ganado el jugador 1");
			else
				System.out.println(VERDE + "Felicidades ha ganado el jugador 2");
		} else
			System.out.println();

	}

	/**
	 * Pedirle a cada jugador la columna a la que quiere disparar
	 * 
	 * @param jugador
	 * @param tablero
	 * @return
	 */
	public int pedirColumna(boolean jugador, Tablero tablero) {
		mostrarTablero(tablero, jugador, false);
		boolean correcto = false;
		String caracteres;
		sc = new Scanner(System.in);
		if (jugador)
			System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
		else
			System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");
		caracteres = sc.nextLine();
		comprobarCaracteres(caracteres, jugador, tablero);
		correcto = tupla.isBuena();

		while (!correcto) {
			System.out.println("Has introducido un caracter invalido, recuerda solo numeros enteros entre 0 y 6");
			if (jugador)
				System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
			else
				System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");

			caracteres = sc.next();
			comprobarCaracteres(caracteres, jugador, tablero);
			correcto = tupla.isBuena();

		}
		
		return tupla.getColumna() - 1;
	}
	
	/**
	 * Metodo para comprobar que los caracteres introducidos por el usuario son correctos, todo se guardara en las variables de la clase tupla
	 * @param caracteres Son los caracteres introducidos por el usuario
	 * @param jugador True jugador 1, False Jugador 2
	 * @param tablero Tablero de juego
	 */

	public void comprobarCaracteres(String caracteres, boolean jugador, Tablero tablero) {

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
			if (columna >= 1 && columna <= tablero.getColumnas())
				tupla.setBuena(true);
			else
				tupla.setBuena(false);

		} else
			tupla.setBuena(false);

	}
	/**
	 * Metodo que se llama si la columna donde queria introducir el usuario una ficha estaba llena
	 * @param jugador true jugador 1, false jugador 2
	 * @param tablero tablero de juego
	 * @return la nueva columna introducida por el usuario
	 */
	public int pedirNuevo(boolean jugador, Tablero tablero) {

		if (jugador)
			System.out.println("Jugador 1, no se ha podidio colocar la ficha en esa columna intenta otra");
		else
			System.out.println("Jugador 2, no se ha podido colocar la ficha en esa columna intenta otra");
		pedirColumna(jugador, tablero);
		return tupla.getColumna()-1;
	}
	/**
	 * Metodo para mostrar el ultimo tablero y el mensaje de victoria
	 * @param tablero tablero de juego
	 * @param jugador true 1, false 2, para saber a quien darle el mensaje de victoria
	 */
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
