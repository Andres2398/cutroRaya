package modelo;

/**
 * Representa el tablero del juego. Permite insertar fichas y comprobar condiciones de victoria
 * en filas, columnas y diagonales.
 */
public class Tablero {
	private int[][] tablero;
	private TuplaModelo tupla;
	public Tablero() {
		tablero = new int[0][0];
		tupla = new TuplaModelo();
	}
	
	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	// Retorna las filas
	public int getFilas() {
		return getTablero().length;
	}

	// Retorna las columnas
	public int getColumnas() {
		return getTablero()[0].length;
	}

	// Retorna el tablero
	public int[][] getTablero() {
		return tablero;
	}

	/**
	 * 
	 * @param columna la columna donde mete la ficha el jugador
	 * @param jugador que jugador es True 1 False 2
	 * @return una tupla que indica si se colocó la ficha y si el jugador gano
	 */
	public TuplaModelo actualizarTablero(int columna, boolean jugador) {

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
	
		if (colocada) {
			comprobarGanar(jugador, i + 1, columna);
		}

		
	
		tupla.setColocoada(colocada);

		return tupla;

	}
	/**
	 * Funcion que que se dedica a llamar a diversas funciones para comprobar la victoria en las filas, columnas y diagonales
	 * @param jugador True si es jugador 1, false si es jugador 2
	 * @param fila de la ultima ficha que ha puesto el jugador
	 * @param columna de la ultima ficha que ha puesto el jugador
	 * 
	 */
	public void comprobarGanar(boolean jugador, int fila, int columna) {
		boolean fin = false;
		int tipoFicha;

		if (jugador) {
			tipoFicha = 1;
		} else
			tipoFicha = 2;

		fin = comprobarGanarFilas(tipoFicha, fila, columna);
		if (!fin) {
			fin = comprobarGanarColumnas(tipoFicha, fila, columna);
			if (!fin) {
				fin = comprobarGanarDiagonalPrin(tipoFicha, fila, columna);
				if (!fin) {
					fin = comprobarGanarDiagonalSec(tipoFicha, fila, columna);
				}

			}
		}
	

		tupla.setFin(fin);

	}
	/**
	 * Funcion que se dedica a comprobar la victoria en las diagonales de abajo izquierda a arriba derecha
	 * @param tipoFicha int que representa la ficha que ha puesto el jugador 1 para jugador 1 , 2 para jugador 2
	 * @param fila de la ultima ficha que ha puesto el jugador
	 * @param columna de la ultima ficha que ha puesto el jugador
	 * @return true si se ha ganado, false si no
	 */
	private boolean comprobarGanarDiagonalSec(int tipoFicha, int fila, int columna) {

		int i = fila + 1;

		int j = columna - 1;

		int ganar = 0;

		while (columna < tablero[0].length && fila >= 0 && tablero[fila][columna] == tipoFicha) {
			
			ganar++;
			columna++;
			fila--;

		}

		while (j >= 0 && i < tablero.length && tablero[i][j] == tipoFicha) {
			ganar++;
			
			j--;
			i++;
		}
		if (ganar >= 4)
			return true;
		else
			return false;
	}
	
	/**
	 * Funcion que se dedica a comprobar la victoria en las diagonales de abajo derecha a arriba izquieda
	 * @param tipoFicha int que representa la ficha que ha puesto el jugador 1 para jugador 1 , 2 para jugador 2
	 * @param fila de la ultima ficha que ha puesto el jugador
	 * @param columna de la ultima ficha que ha puesto el jugador
	 * @return true si se ha ganado, false si no
	 */
	private boolean comprobarGanarDiagonalPrin(int tipoFicha, int fila, int columna) {
		int i = fila + 1;
		int j = columna + 1;
		int ganar = 0;
		while ((columna >= 0 && fila >= 0 && tablero[fila][columna] == tipoFicha)) {
			ganar++;
			columna--;
			fila--;
		

		}
		while (j < tablero[0].length && i < tablero.length && tablero[i][j] == tipoFicha) {
			ganar++;
			j++;
			i++;
			
		}
		

		if (ganar >= 4)
			return true;
		else
			return false;

	}
	/**
	 * Funcion que se dedica a comprobar la victoria en las columnas de arriba a abajo
	 * @param tipoFicha int que representa la ficha que ha puesto el jugador 1 para jugador 1 , 2 para jugador 2
	 * @param fila de la ultima ficha que ha puesto el jugador
	 * @param columna de la ultima ficha que ha puesto el jugador
	 * @return true si se ha ganado, false si no
	 */
	private boolean comprobarGanarColumnas(int tipoFicha, int i, int columna) {
		int ganar = 0;

		while (i < tablero.length && tablero[i][columna] == tipoFicha) {
			ganar++;
			i++;

		}
		if (ganar >= 4)
			return true;
		else
			return false;

	}
	/**
	 * Funcion que se dedica a comprobar la victoria en las filas de derecha a izquierda o viceversa
	 * @param tipoFicha int que represnta la ficha que ha puesto el jugador 1 para jugador 1 , 2 para jugador 2
	 * @param fila de la ultima ficha que ha puesto el jugador
	 * @param columna de la ultima ficha que ha puesto el jugador
	 * @return true si se ha ganado, false si no
	 */
	public boolean comprobarGanarFilas(int tipoFicha, int i, int columna) {

		int ganar = 0;
		int j = columna - 1;
		while ((columna < tablero[0].length && tablero[i][columna] == tipoFicha)) {
			
			ganar++;
			
			columna++;
			

		}
		while (j >= 0 && tablero[i][j] == tipoFicha) {
			
			ganar++;
			
			j--;
		}
		if (ganar >= 4)
			return true;
		else
			return false;

	}
}
