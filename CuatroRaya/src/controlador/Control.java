package controlador;

import modelo.Logica;
import modelo.Tablero;
import vista.Interfaz;

public class Control {

	Logica logica;
	Interfaz interfaz;

	public Control() {
		logica = new Logica();
		interfaz = new Interfaz();
	}
	
	/**
	 * Bucle del juego
	 */
	public void start() {

		boolean fin = false;
		int columna;
		boolean colocada;
		Tablero tablero = logica.iniciarPartida();
		boolean jugador = true;
		int turnos = 0;

		do {

			interfaz.mostrarTablero(tablero);
			columna = interfaz.pedirColumna(jugador);
			colocada = logica.introducirFicha(columna, tablero, jugador);
			if (!colocada) {
				introducirNuevo(colocada, tablero, jugador);

			}
			turnos++;
			if(turnos>4)
				fin = logica.comprobarFin(jugador);

			if (jugador)
				jugador = false;
			else
				jugador = true;

		} while (!fin);

	}
	
	/**
	 * 
	 * @param colocada saber si la ficha ha sido colocada o la columna estaba llena y no se puede meter otra ficha 
	 * @param tablero tablero de juego
	 * @param jugador jugador true 1 jugador false 2
	 */
	private void introducirNuevo(boolean colocada, Tablero tablero, boolean jugador) {
		int columna;
		while (!colocada) {
			columna = interfaz.pedirNuevo(jugador);
			colocada = logica.introducirFicha(columna, tablero, jugador);

		}

	}

}
