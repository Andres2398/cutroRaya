package modelo;

public class Logica {
	private Tablero tablero;
	private boolean jugador;
	private int turnos;

	public Logica() {
		tablero = new Tablero();
		jugador = true;
		turnos = 0;
	}

	public boolean getJugador() {
		return jugador;
	}

	public Tablero getTablero() {
		return tablero;
	}

	/**
	 * Todo pasa por aqui para controlar lo que se envia a control
	 * 
	 * @param columna
	 * @param tablero
	 * @param jugador
	 * @return
	 */

	public boolean[] introducirFicha(int columna) {

		boolean[] comprobaciones = tablero.actualizarTablero(columna, jugador);
		if (comprobaciones[0]) {
			turnos++;

		}
		if (turnos == tablero.getColumnas() * tablero.getFilas() && !comprobaciones[1]) {
			// tupla empate = true;
		}
			

			return comprobaciones;

	}

	public int getTurnos() {
		return turnos;
	}

	public void cambiarJugador() {
		jugador = !jugador;
	}

}
