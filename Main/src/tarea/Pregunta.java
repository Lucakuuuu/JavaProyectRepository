package tarea;

public class Pregunta 
{
	private String enunciado;
	private String[] respuestas;
	private int respuestaCorrecta;
	
	public Pregunta(String enunciado, String[] respuestas, int respuestaCorrecta)
	{
		this.enunciado = enunciado;
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
	}
	
	public String getEnunciado()
	{
		return enunciado;
	}
	public String[] getRespuestas()
	{
		return respuestas;
	}
	public int getRespuestaCorrecta()
	{
		return respuestaCorrecta;
	}
	
	public boolean esCorrecta(int respuestaUsuario)
	{
		return respuestaUsuario == respuestaCorrecta;
	}
}
