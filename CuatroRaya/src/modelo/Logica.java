package modelo;

public class Logica {
	private Tablero tablero;
	private boolean jugador;

	public Logica() {
		tablero = new Tablero();
		jugador=true;
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
		if (comprobaciones[0])
			cambiarJugador();

		return comprobaciones;

	}

	private void cambiarJugador() {
		jugador = !jugador;
	}

	

}
