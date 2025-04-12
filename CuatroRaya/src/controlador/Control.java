package controlador;

import modelo.Logica;
import modelo.Tablero;
import modelo.TuplaModelo;
import vista.Interfaz;
import vista.TuplaDificultad;

public class Control {

	Logica logica;
	Interfaz interfaz;
	TuplaModelo tupla;
	TuplaDificultad tuplaDificultad;

	public Control() {
		logica = new Logica();
		interfaz = new Interfaz();
		tupla = new TuplaModelo();
		tuplaDificultad = new TuplaDificultad();
	}

	/**
	 * Bucle del juego
	 */
	public void start() {

		int columna;
		tuplaDificultad = interfaz.elegirTamañoTablero();
		logica.intoducirTamañoTablero(tuplaDificultad.getFilas(),tuplaDificultad.getColumnas());
		do {

			columna = interfaz.pedirColumna(logica.getJugador(), logica.getTablero());
			tupla = logica.introducirFicha(columna);
			if (!tupla.isColocoada()) {
				introducirNuevo(logica.getTablero());

			}

			if (tupla.isFin()) {
				interfaz.mostrarTablero(logica.getTablero());
				interfaz.victoria(logica.getJugador());
			}

			if (tupla.isEmpate()) {
				tupla.setFin(true);
				interfaz.mostrarTablero(logica.getTablero());
				interfaz.empate();

			}
			
			interfaz.retrocederTurnos(logica.getTurnos());
			logica.cambiarJugador();
		} while (!tupla.isFin());

	}

	/**
	 * 
	 * @param tablero tablero de juego
	 * @param jugador jugador true 1 jugador false 2
	 * @return
	 */
	private void introducirNuevo(Tablero tablero) {
		int columna;
		while (!tupla.isColocoada()) {
			columna = interfaz.pedirNuevo(logica.getJugador(), tablero);
			tupla = logica.introducirFicha(columna);

		}

	}

}
