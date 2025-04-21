package vista;

import java.util.Scanner;

import modelo.Tablero;

/**
 * Clase interfaz que se dedicara a toda la comunicacion con el usuario desde
 * mostrar el tablero a pedir al usuario donde quiere introducir la ficha
 */
public class Interfaz {
	private Scanner sc;
	private Tupla tupla;
	private static final String ROJO = "\u001b[31m"; // codigo para colorear el texto rojo
	private static final String AZUL = "\033[34m"; // codigo para colorear el texto azul
	private static final String RESET = "\u001B[0m";
	private static final String VERDE = "\033[32m";
	private TuplaDificultad tuplaDificultad;

	/**
	 * Constructor de la clase interfaz donde inicamos un objeto tupla
	 */
	public Interfaz() {
		tupla = new Tupla();
		sc = new Scanner(System.in);
		tuplaDificultad = new TuplaDificultad();
	}

	/**
	 * Funcion para mostrar el tablero jugador 1 seran las X y 2 seran los 0
	 * 
	 * @param tablero
	 * @param fin
	 * @param jugador
	 */
	public void mostrarTablero(Tablero tablero) {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		for (int i = 0; i < tablero.getColumnas(); i++) {
			if (i < 10)
				System.out.print(VERDE + "   " + (i + 1) + "  " + RESET);
			else
				System.out.print(VERDE + "  " + (i + 1) + "  " + RESET);
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
		System.out.println();

	}

	/**
	 * Pedirle a cada jugador la columna a la que quiere disparar
	 * 
	 * @param jugador
	 * @param tablero
	 * @param turnos
	 * @param repetido 
	 * @return
	 */
	public int pedirColumna(boolean jugador, Tablero tablero, int turnos, boolean repetido) {
		mostrarTablero(tablero);
		boolean correcto = false;
		String caracteres;
		if(repetido) {
			if (jugador)
				System.out.println("Jugador 1 no se ha podidio colocar la ficha en esa columna intenta otra");
			else
				System.out.println("Jugador 2 no se ha podido colocar la ficha en esa columna intenta otra");
		}
			

		if (turnos > 4 && !repetido) {
			if (jugador)
				System.out.println(
						"Jugador 1 introduce la columna donde quieres poner la ficha o pulse r para retroceder");
			else
				System.out.println(
						"Jugador 2 introduce la columna donde quieres poner la ficha o pulse r para retroceder");

		} else {

			if (jugador)
				System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
			else
				System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");
		}
		caracteres = sc.nextLine();
		if (turnos > 4 && (caracteres.equals("r") || caracteres.equals("R"))) {
			return -1;
		}
		comprobarCaracteres(caracteres, tablero);
		correcto = tupla.isBuena();

		while (!correcto) {
			System.out.println("Has introducido un caracter invalido, recuerda solo numeros enteros entre 0 y 6");
			if (turnos > 4) {
				if (jugador)
					System.out.println(
							"Jugador 1 introduce la columna donde quieres poner la ficha o pulse r para retroceder");
				else
					System.out.println(
							"Jugador 2 introduce la columna donde quieres poner la ficha o pulse r para retroceder");

			} else {

				if (jugador)
					System.out.println("Jugador 1 introduce la columna donde quieres poner la ficha");
				else
					System.out.println("Jugador 2 introduce la columna donde quieres poner la ficha");
			}

			caracteres = sc.nextLine();
			if (turnos > 4 && (caracteres.equals("r") || caracteres.equals("R"))) {
				return -1;
			}
			comprobarCaracteres(caracteres, tablero);
			correcto = tupla.isBuena();

		}

		return tupla.getColumna() - 1;
	}

	/**
	 * Metodo para comprobar que los caracteres introducidos por el usuario son
	 * correctos, todo se guardara en las variables de la clase tupla
	 * 
	 * @param caracteres Son los caracteres introducidos por el usuario
	 * @param jugador    True jugador 1, False Jugador 2
	 * @param tablero    Tablero de juego
	 */

	public void comprobarCaracteres(String caracteres, Tablero tablero) {

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
				columna += (caracteres.charAt(i) - '0') * multiplicar;
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
	 * Metodo que se llama si la columna donde queria introducir el usuario una
	 * ficha estaba llena
	 * 
	 * @param jugador true jugador 1, false jugador 2
	 * @param tablero tablero de juego
	 * @param turnos
	 * @return la nueva columna introducida por el usuario
	 */
	public int pedirNuevo(boolean jugador, Tablero tablero, int turnos) {
		pedirColumna(jugador, tablero, turnos, true);
		return tupla.getColumna() - 1;
	}

	/**
	 * Metodo para mostrar el ultimo tablero y el mensaje de victoria
	 * 
	 * @param tablero tablero de juego
	 * @param jugador true 1, false 2, para saber a quien darle el mensaje de
	 *                victoria
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
	/**
	 * mensaje que ocurre en caso de empate
	 */
	public void empate() {
		System.out.println("No quedan jugadas posibles hay un empate");

	}
	/**
	 * mensaje que se muestra al ganar la partida
	 * @param jugador el jugador que ha ganado
	 * @param turnos la cantidad de turnos jugados
	 */
	public void victoria(boolean jugador, int turnos) {
		if (jugador)
			System.out.println(VERDE + "Felicidades ha ganado el jugador 1, se han jugado " + turnos + " turnos");
		else
			System.out.println(VERDE + "Felicidades ha ganado el jugador 2 se han jugado" + turnos + " turnos3");

	}
	/**
	 * Metodo para elegir el tamaño del tablero 
	 * @return objeto tupla con el tamaño de la matriz
	 */
	public TuplaDificultad elegirTamañoTablero() {
		System.out.println(
				"Selecciona el tamaño del tablero\n1 Pequeño: 6X7\n2 Mediano: 8X9\n3 Grande: 10X11 \n4 Personalizado");
		String input = sc.nextLine();
		while (!comprobarTamaño(input)) {
			System.out.println("Has seleccionado un caracter incorrecto");
			System.out.println(
					"Selecciona el tamaño del tablero\n1: Pequeño (6X7)\n2 Mediano: 8X9\n3 Grande: 10X11 \n4 Personalizado");
			input = sc.nextLine();
		}

		return tuplaDificultad;
	}
	
	/**
	 * Comprobar que lo ingresaado por el usuario es correcto
	 * @param input entrada del usuario
	 * @return true si es correcto la entrada, false si no
	 */
	private boolean comprobarTamaño(String input) {
		if (input.length() > 1)
			return false;
		
		if (input.charAt(0) - '0' == 1 || input.charAt(0) - '0' == 2 || input.charAt(0) - '0' == 3
				|| input.charAt(0) - '0' == 4) {

			if (input.charAt(0) - '0' == 1) {
				tuplaDificultad.setFilas(6);
				tuplaDificultad.setColumnas(7);
			} else if (input.charAt(0) - '0' == 2) {
				tuplaDificultad.setFilas(8);
				tuplaDificultad.setColumnas(9);

			} else if (input.charAt(0) - '0' == 3) {
				tuplaDificultad.setFilas(10);
				tuplaDificultad.setColumnas(11);

			} else if (input.charAt(0) - '0' == 4) {
				pedirDificultadPersonalizada();
			}

			return true;
		}

		return false;
	}
	/**
	 * Metodo para pedir una dificultad personalizada dentro de unos limites, la dificultad sera el tamaño 
	 * de la matriz
	 */
	private void pedirDificultadPersonalizada() {
		System.out.println(
				"Elige la cantidad de filas que tendra la matriz, recuerda que lo minimo posible sera 4 filas y lo maximo de 15");
		String input = sc.nextLine();
		while (!comprobarTamañoPersonalizadas(input, 20)) {
			System.out.println("Has seleccionado un caracter incorrecto");
			System.out.println(
					"Elige la cantidad de filas que tendra la matriz, recuerda que lo minimo posible sera 4 filas y lo maximo de 15");
			input = sc.nextLine();
		}
		System.out.println(
				"Elige la cantidad de columnas que tendra la matriz, recuerda que lo minimo posible sera 4 filas y lo maximo de 20");
		input = sc.nextLine();
		while (!comprobarTamañoPersonalizadas(input, 40)) {
			System.out.println("Has seleccionado un caracter incorrecto");
			System.out.println(
					"Elige la cantidad de filas que tendra la matriz, recuerda que lo minimo posible sera 4 filas y lo maximo de 20");
			input = sc.nextLine();
		}
	}

	private boolean comprobarTamañoPersonalizadas(String input, int tamano) {

		char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		int correcto = 0;
		int numeroInput = 0;
		int multiplicar = 1;
		boolean permitido = false;

		for (int i = input.length() - 1; i >= 0; i--) {
			permitido = false;
			for (int j = 0; j < numeros.length; j++) {
				if (input.charAt(i) == numeros[j]) {
					correcto++;
					permitido = true;

				}

			}

			if (permitido) {
				numeroInput += (input.charAt(i) - '0') * multiplicar;
				multiplicar *= 10;

			}

		}
		if (correcto == input.length()) {
			if (numeroInput <= tamano) {
				if (tamano == 20)
					tuplaDificultad.setFilas(numeroInput);
				else
					tuplaDificultad.setColumnas(numeroInput);
				return true;
			}
		}
		return false;

	}

	/**
	 * Metodo para pedir cuantos turnos retroceder
	 * @param turnos cantidad de turnos que se han jugado
	 * @return la cantidad de turnos que el usuario quiere retroceder
	 */

	public int retrocederTurnos(int turnos) {
		System.out
				.println("Cuantos turnos quieres retroceder, recuerda hasta ahora se han jugado " + turnos + " turnos");

		String input = sc.nextLine();
		while (!comprobarTurnos(input, turnos)) {
			System.out.println("Has seleccionado un numero de turnos incorrecto");
			System.out.println(
					"Cuantos turnos quieres retroceder, recuerda hasta ahora se han jugado " + turnos + " turnos");
			input = sc.nextLine();
		}
		return tupla.getTurnosRetroceder();
	}
	

	/**
	 * Metodo para depurar la entrada de los turnos que quiere retroceder el usuario 
	 * @param input la entrada del usuario
	 * @param turnos cantidad de turnos que se han jugado
	 * @return true si los turnos que quiere retroceder el usuario son menores o iguales a los turnos jugados
	 * false si no
	 */
	
	private boolean comprobarTurnos(String input, int turnos) {
		char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		int correcto = 0;
		int numeroInput = 0;
		int multiplicar = 1;
		boolean permitido = false;

		for (int i = input.length() - 1; i >= 0; i--) {
			permitido = false;
			for (int j = 0; j < numeros.length; j++) {
				if (input.charAt(i) == numeros[j]) {
					correcto++;
					permitido = true;

				}

			}

			if (permitido) {
				numeroInput += (input.charAt(i) - '0') * multiplicar;
				multiplicar *= 10;

			}

		}
		if (numeroInput <= turnos) {
			tupla.setTurnosRetroceder(numeroInput);
			return true;
		}
		return false;

	}
}