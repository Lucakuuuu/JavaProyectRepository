package tarea;

public class Puntajes {
	private String materia;
	private int puntaje;
	private int maxPuntaje;
	
	public Puntajes(String materia, int puntaje, int maxPuntaje) {
		this.materia = materia;
		this.puntaje = puntaje;
		this.maxPuntaje = maxPuntaje;
	}
	
	public String getMateria() {
		return materia;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int getMaxPuntaje() {
		return maxPuntaje;
	}
	
	public String toString()
	{
		return "Tema: " + materia
				+ "\nPuntuación: " + puntaje
				+ "\nPuntaje Máximo: " + maxPuntaje;
	}
}
