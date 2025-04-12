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

	public TuplaModelo introducirFicha(int columna) {

		TuplaModelo tupla = tablero.actualizarTablero(columna, jugador);
		if (tupla.isColocoada()) {
			turnos++;

		}

		if (turnos == tablero.getColumnas() * tablero.getFilas() && !tupla.isFin())
			tupla.setEmpate(true);

		return tupla;

	}

	public int getTurnos() {
		return turnos;
	}

	public void cambiarJugador() {
		jugador = !jugador;
	}

	public void intoducirTamañoTablero(int filas, int columnas) {
		int[][] tablero = new int[filas][columnas];
		this.tablero.setTablero(tablero);
	}

}
