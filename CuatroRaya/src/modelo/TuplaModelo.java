package modelo;
/**
 * Clase con 3 booleanos para saber si se ha gando la partida, si se ha empatado y si se ha colocado la ficha
 */
public class TuplaModelo {
	private boolean fin;
	private boolean colocoada;
	private boolean empate;
	/**
	 * Contstructor de la clase inicamos los 3 booleanos a false
	 */
	public TuplaModelo() {
		fin=false;
		colocoada=false;
		empate=false;
		
	}
	/**
	 * Metodo para saber si se ha ganado
	 * @return true si se ha ganado, false si no
	 */
	public boolean isFin() {
		return fin;
	}
	/**
	 * Metodo para establecer si se ha ganado
	 * @param fin true si se ha ganado, false si no
	 */
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	/**
	 * Metodo para saber si se ha colocado la ficha
	 * @return true si se ha colocado, false si no
	 */
	public boolean isColocoada() {
		return colocoada;
	}
	/**
	 * Metodo para establecer si se ha colocado la ficha
	 * @param fin true si se ha colocado la ficha, false si no
	 */
	public void setColocoada(boolean colcoada) {
		this.colocoada = colcoada;
	}
	/**
	 * Metodo para saber si se ha empatado
	 * @return true si se ha empatado, false si no
	 */
	public boolean isEmpate() {
		return empate;
	}
	/**
	 * Metodo para establecer si se ha empatado
	 * @param fin true si se ha empatado, false si no
	 */
	public void setEmpate(boolean empate) {
		this.empate = empate;
	}
	
}
