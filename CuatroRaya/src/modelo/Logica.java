package modelo;

public class Logica {

	public Tablero iniciarPartida() {
		Tablero tablero = new Tablero();

		return tablero;

	}
	/**
	 * Todo pasa por aqui para controlar lo que se envia a control
	 * @param columna
	 * @param tablero
	 * @param jugador
	 * @return
	 */

	public boolean introducirFicha(int columna, Tablero tablero, boolean jugador) {

		boolean colocada = tablero.actualizarTablero(columna, jugador);

		return colocada;

	}

	public boolean comprobarFin(boolean jugador) {
		boolean fin;
		if (jugador == true) {
			fin = comprobarGanarJugador1();
		} else
			fin = comprobarGanarJugador2();

		return fin;

	}

	private boolean comprobarGanarJugador1() {

		return false;
	}

	private boolean comprobarGanarJugador2() {

		return false;
	}

}
