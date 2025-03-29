package modelo;

public class Tablero {
	private int[][] tablero;
	private int turnos;

	public Tablero() {
		tablero = new int[6][7];
	}
	//Retorna las filas

	public int getFilas() {
		return getTablero().length;
	}
	//Retorna las columnas
	public int getColumnas() {
		return getTablero()[0].length;
	}
	
	//Retorna el tablero
	public int[][] getTablero() {
		return tablero;
	}
	
	
	/**
	 * 
	 * @param columna la columna donde mete la ficha el jugador
	 * @param jugador que jugador es True 1 False 2
	 * @return retornaremos 2 booleanos uno para saber si ha metido la ficha y otro para saber si ha ganado
	 */
	public boolean actualizarTablero(int columna, boolean jugador) {

		int i = tablero.length - 1;
		boolean colocada = false;

		while (i >= 0 && !colocada) {
			if (tablero[i][columna] == 0) {
				if (jugador == true) {
					tablero[i][columna] = 1;
					colocada = true;
				} else {
					tablero[i][columna] = 2;
					colocada = true;
				}

			}
			i--;

		}
		if (colocada = true) {
			turnos++;
		}
		if (turnos > 6 && jugador)
			comprobarGanar(i, columna, 1);
		else if (turnos > 6 && !jugador)
			comprobarGanar(i, columna, 2);
		System.out.println("¿Esta colocada? = " + colocada);
		return colocada;

	}
	
	/**
	 * 
	 * @param i --> fila de donde ha caido la ficha
	 * @param columna ---> columna donde esta la ficha
	 * @param tipoCasilla ---> si es la casilla del jugador 1 o 2
	 * @return retornamos true o false segun si se encuentra 3 fichas seguidas del jugador mas la de la posicion
	 */
	private boolean comprobarGanar(int i, int columna, int tipoCasilla) {

		int ganar = 0;
		if (ganarIzquierda(i, columna, tipoCasilla) == 3)
			return true;
		else if (ganarDerecha(i, columna, tipoCasilla) == 3)
			return true;
		else if (ganarArriba(i, columna, tipoCasilla) == 3)
			return true;
		return false;
	}

	private int ganarArriba(int i, int columna, int tipoCasilla) {
		int ganar = 0;

		return ganar;
	}
	
	/**
	 * 
	 * @param i --> fila de donde ha caido la ficha
	 * @param columna ---> columna donde esta la ficha
	 * @param tipoCasilla ---> si es la casilla del jugador 1 o 2
	 * @return retornamos true o false segun si se encuentra 3 fichas seguidas del jugador mas la de la posicion
	 */
	private int ganarDerecha(int i, int columna, int tipoCasilla) {
		int ganar = 0;
		if (i + 1 < tablero[0].length && tablero[i + 1][columna] == tipoCasilla)
			ganar++;
		else if (i + 2 < tablero[0].length && tablero[i + 2][columna] == tipoCasilla)
			ganar++;
		else if (i + 3 < tablero[0].length && tablero[i + 3][columna] == tipoCasilla)
			ganar++;

		return ganar;
	}
	/**
	 * 
	 * @param i --> fila de donde ha caido la ficha
	 * @param columna ---> columna donde esta la ficha
	 * @param tipoCasilla ---> si es la casilla del jugador 1 o 2
	 * @return retornamos true o false segun si se encuentra 3 fichas seguidas del jugador mas la de la posicion
	 */
	private int ganarIzquierda(int i, int columna, int tipoCasilla) {
		int ganar = 0;
		if (i - 1 >= 0 && tablero[i - 1][columna] == tipoCasilla)
			ganar++;
		else if (i - 2 >= 0 && tablero[i - 2][columna] == tipoCasilla)
			ganar++;
		else if (i - 3 >= 0 && tablero[i - 3][columna] == tipoCasilla)
			ganar++;

		return ganar;

	}

}
