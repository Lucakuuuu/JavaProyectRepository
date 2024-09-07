<<<<<<< HEAD
package tarea;

public class Nota 
{
	private String estudiante;
	private String tema;
	private int puntuacion;
	private int maxPuntuacion;
	
	public Nota(String estudiante, String tema, int puntuacion, int maxPuntuacion)
	{
		this.estudiante = estudiante;
		this.tema = tema;
		this.puntuacion = puntuacion;
		this.maxPuntuacion = maxPuntuacion;
	}
	
	public String getEstudiante()
	{
		return estudiante;
	}
	public String getTema()
	{
		return tema;
	}
	public int getPuntuacion()
	{
		return puntuacion;
	}
	public int getMaxPuntuacion()
	{
		return maxPuntuacion;
	}
	public void setEstudiante(String estudiante)
	{
		this.estudiante = estudiante;
	}
	public void setTema(String tema)
	{
		this.tema = tema;
	}
	public void setPuntuacion(int puntuacion)
	{
		this.puntuacion = puntuacion;
	}
	public void setMaxPuntuacion(int maxPuntuacion)
	{
		this.maxPuntuacion = maxPuntuacion;
	}
	
	public String toString()
	{
		return "Estudiante: " + estudiante + "; Tema: " + tema + "; Puntuación: " + puntuacion + "; Puntuación Máxima: " + maxPuntuacion;
	}
}
=======
package tarea;

public class Nota 
{
	private String estudiante;
	private String tema;
	private int puntuacion;
	private int maxPuntuacion;
	
	public Nota(String estudiante, String tema, int puntuacion, int maxPuntuacion)
	{
		this.estudiante = estudiante;
		this.tema = tema;
		this.puntuacion = puntuacion;
		this.maxPuntuacion = maxPuntuacion;
	}
	
	public String getEstudiante()
	{
		return estudiante;
	}
	public String getTema()
	{
		return tema;
	}
	public int getPuntuacion()
	{
		return puntuacion;
	}
	public int getMaxPuntuacion()
	{
		return maxPuntuacion;
	}
	public void setEstudiante(String estudiante)
	{
		this.estudiante = estudiante;
	}
	public void setTema(String tema)
	{
		this.tema = tema;
	}
	public void setPuntuacion(int puntuacion)
	{
		this.puntuacion = puntuacion;
	}
	public void setMaxPuntuacion(int maxPuntuacion)
	{
		this.maxPuntuacion = maxPuntuacion;
	}
	
	public String toString()
	{
		return "Estudiante: " + estudiante + "; Tema: " + tema + "; Puntuación: " + puntuacion + "; Puntuación Máxima: " + maxPuntuacion;
	}
}
>>>>>>> 86e655e15bfc038b25100b9b18dbac929d38e38d
