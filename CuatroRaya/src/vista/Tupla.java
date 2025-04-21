package vista;
/**
 * clase Tupla con diferentes valores para conseguir devolver mas de un valor en las funciones
 */
public class Tupla {
	private int columna;
	private boolean buena;
	private int turnosRetroceder;
	
	
	/**
	 * obtener la cantidad de turnos que quiere retroceder el usuario
	 * @return int de los turnos que quiere retroceder
	 */
	public int getTurnosRetroceder() {
		return turnosRetroceder;
	}
	/**
	 * Establercer los turnos que quiere retroceder el usuario
	 * @param turnosRetroceder los turnos que quiere retoceder el usuario
	 */
	public void setTurnosRetroceder(int turnosRetroceder) {
		this.turnosRetroceder = turnosRetroceder;
	}
	/**
	 * Obtener la columna a introducir la ficha
	 * @return un int que representa la columna
	 */
	public int getColumna() {
		return columna;
	}
	/**
	 * Establecer la columna que quiere introducir la ficha el usuario
	 * @param columna la columna en la que se quiere introducir la ficha
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}
	/**
	 * saber si la columna que ha introducido el usuario esta en los limites del tablero
	 * @return true si esta dentro de los limites false si no
	 */
	public boolean isBuena() {
		return buena;
	}
	/**
	 * EStablecer si la columna esta dentro de los limites o no 
	 * @param buena true si esta dento, false si no
	 */
	public void setBuena(boolean buena) {
		this.buena = buena;
	}

}
