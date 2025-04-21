package modelo;
/**
 * Clase logica se trata de conectar a control con tablero y
 * viceversa tambien realiza metodos como vaciar tablero y elegir la cantidad de
 * caracteres buenos y malos que habra en el tablero
 */
public class Logica {
	private Tablero tablero;
	private boolean jugador;
	private Tablero[] arrayTableros;
	private int turnosTablero;
	private int turnosPartida;
/**
 * Constructor de la logica
 */
	public Logica() {
		tablero = new Tablero();
		jugador = true;
		turnosTablero = 0;
		turnosPartida = 0;
		arrayTableros = new Tablero[50];
	}
	/**
	 * Saber el jugador que esta jugando
	 * @return true jugador 1, false 2
	 */
	public boolean getJugador() {
		return jugador;
	}
	/**
	 * Metodo para obtener el tablero de juego
	 * @return tablero de juego
	 */
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

	/**
	 * Metodo para introducir la ficha  en el tablero 
	 * @param columna donde se quiere introducir la ficha
	 * @return objeto tupla con los valores boolneanos de si se ha introducido la ficha, si se ha ganado la partida,
	 * o se ha empatado la partida
	 */
	public TuplaModelo introducirFicha(int columna) {

		TuplaModelo tupla = tablero.actualizarTablero(columna, jugador);
		if (tupla.isColocoada()) {
			turnosTablero++;
			turnosPartida++;
		    arrayTableros[turnosTablero] = tablero.copiar();

		}

		if (turnosTablero == tablero.getColumnas() * tablero.getFilas() && !tupla.isFin())
			tupla.setEmpate(true);

		return tupla;

	}
	/**
	 * Metodo para saber la cantidad de turnos que se han movido en el tablero, no los turnos totales
	 * de la partida
	 * @return cantidad de turnos 
	 */
	public int getTurnosTablero() {
		return turnosTablero;
	}
	/**
	 * Metodo para cambiar el turno del jugador 
	 */
	public void cambiarJugador() {
		jugador = !jugador;
	}
	
	/**
	 * Metodo para establecer el tamaño del tablero 
	 * @param filas del tablero
	 * @param columnas del tablero
	 */
	public void intoducirTamañoTablero(int filas, int columnas) {
		int[][] tablero = new int[filas][columnas];
		this.tablero.setTablero(tablero);
	}
	/**
	 * Metodo para retroceder los turnos en el tablero
	 * @param turnosRetroceder turnos que quiere retroceder el usuario
	 */
	public void retrocederTurnos(int turnosRetroceder) {
		
		System.out.println(turnosRetroceder);
		Tablero estadoAnterior = arrayTableros[turnosTablero - turnosRetroceder].copiar();
		turnosTablero -= turnosRetroceder;
		tablero = estadoAnterior;
	}
	/**
	 * Metodo para saber la cantidad de turnos de la partida
	 * @return cantidad de turnos 
	 */
	public int getTurnosPartida() {
		return turnosPartida;
	}
	
	
	//public void mostrarTablero

}
