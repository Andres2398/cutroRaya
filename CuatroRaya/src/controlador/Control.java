package controlador;

import modelo.Logica;
import modelo.Tablero;
import vista.Interfaz;

public class Control {

	Logica logica;
	Interfaz interfaz;
	boolean[] comprobaciones;

	public Control() {
		logica = new Logica();
		interfaz = new Interfaz();
	}

	/**
	 * Bucle del juego
	 */
	public void start() {

		int columna;

		do {

			columna = interfaz.pedirColumna(logica.getJugador(), logica.getTablero());
			comprobaciones = logica.introducirFicha(columna);
			if (!comprobaciones[0]) {
				introducirNuevo(comprobaciones[0], logica.getTablero());

			}

			if (comprobaciones[1] == true)
				interfaz.mostrarTablero(logica.getTablero(), logica.getJugador(), true);
			// if (logica.getTurnos()==logica.)
			// tupla
			logica.cambiarJugador();
		} while (!comprobaciones[1]);

	}

	/**
	 * 
	 * @param colocada saber si la ficha ha sido colocada o la columna estaba llena
	 *                 y no se puede meter otra ficha
	 * @param tablero  tablero de juego
	 * @param jugador  jugador true 1 jugador false 2
	 * @return
	 */
	private void introducirNuevo(boolean colocada, Tablero tablero) {
		int columna;
		while (!colocada) {
			columna = interfaz.pedirNuevo(logica.getJugador(), tablero);
			comprobaciones = logica.introducirFicha(columna);
			colocada = comprobaciones[0];

		}

	}

}
