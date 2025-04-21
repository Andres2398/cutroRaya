package vista;

/**
 * Clase para establecer las filas y las columnas del tablero
 */
public class TuplaDificultad {
	private int filas;
	private int columnas;

	/**
	 * Cntidad de filas de la matriz
	 * 
	 * @return int de las filas de la matriz
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Establecer Filas de la matriz
	 * 
	 * @param filas numero de filas
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}

	/**
	 * Cntidad de columnas de la matriz
	 * 
	 * @return int de las columnas de la matriz
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Establecer columnas de la matriz
	 * 
	 * @param columnas numero de filas
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
}
