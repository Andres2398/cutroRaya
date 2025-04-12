package modelo;

public class TuplaModelo {
	private boolean fin;
	private boolean colocoada;
	private boolean empate;
	
	public TuplaModelo() {
		fin=false;
		colocoada=false;
		empate=false;
		
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	public boolean isColocoada() {
		return colocoada;
	}
	public void setColocoada(boolean colcoada) {
		this.colocoada = colcoada;
	}
	public boolean isEmpate() {
		return empate;
	}
	public void setEmpate(boolean empate) {
		this.empate = empate;
	}
}
