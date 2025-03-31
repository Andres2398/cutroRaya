package modelo;

public class Tablero {
	private int[][] tablero;

	public Tablero() {
		tablero = new int[6][7];
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
	 * @return retornaremos 2 booleanos uno para saber si ha metido la ficha y otro
	 *         para saber si ha ganado
	 */
	public boolean[] actualizarTablero(int columna, boolean jugador) {

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
		boolean fin = false;
		boolean[] comprobaciones = new boolean[2];
		if (colocada == true) {
			fin = comprobarGanar(jugador, i, columna);
		}

		System.out.println("¿Esta colocada? = " + colocada);
		comprobaciones[0] = colocada;
		comprobaciones[1] = fin;

		return comprobaciones;

	}

	public boolean comprobarGanar(boolean jugador, int i, int columna) {
		boolean fin = false;
		int tipoFicha;

		if (jugador == true) {
			tipoFicha = 1;
		} else
			tipoFicha = 2;

		fin = comprobarGanarFilas(tipoFicha, i, columna);
		if (fin == false) {
			fin = comprobarGanarColumnas(tipoFicha, i, columna);
			if (fin == false) {
				fin = comprobarGanarDiagonalPrin(tipoFicha, i, columna);
				if (fin == false) {
					fin = comprobarGanarDiagonalSec(tipoFicha, i, columna);
				}

			}
		}
		System.out.println(fin);

		return fin;

	}

	private boolean comprobarGanarDiagonalSec(int tipoFicha, int fila, int columna) {

		int i = fila;

		int j = columna;

		int ganar = 0;

		while (columna - 1 < tablero[0].length && fila - 1 >= 0 && tablero[fila][columna] == 1) {
			columna++;
			fila--;
			ganar++;

		}

		while (j >= 0 && i < tablero.length && tablero[i][j] == 1) {

			j--;
			i++;
			ganar++;
		}
		return false;
	}

	private boolean comprobarGanarDiagonalPrin(int tipoFicha, int fila, int columna) {
		int i = fila;
		int j = columna;
		int ganar = 0;
		while (columna - 1 >= 0 && fila - 1 >= 0 && tablero[fila][columna] == 1) {
			ganar++;
			columna--;
			fila--;

		}

		while (j < tablero[0].length && i < tablero.length && tablero[fila + 1][columna + 1] == 1) {
			ganar++;
			j++;
			i++;
		}
		if (ganar >= 4)
			return true;
		else
			return false;

	}

	private boolean comprobarGanarColumnas(int tipoFicha, int i, int columna) {
		int ganar = 0;
		int j = columna + 1;
		System.out.println(i + "" + columna);
		while (i >= 0 && tablero[i][columna] == tipoFicha) {

			ganar++;
			i--;

		}
		while (j < tablero[0].length - 1 && tablero[i][j] == tipoFicha) {
			ganar++;
			j++;
		}
		if (ganar >= 4)
			return true;
		else
			return false;

	}

	public boolean comprobarGanarFilas(int tipoFicha, int i, int columna) {

		int ganar = 0;
		int j = i + 1;
		while (i >= 0 && tablero[i][columna] == tipoFicha) {
			ganar++;
			i--;

		}
		while (j < tablero[0].length - 1 && tablero[j][columna] == tipoFicha) {
			ganar++;
			j++;
		}
		if (ganar >= 4)
			return true;
		else
			return false;

	}
}
