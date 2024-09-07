package tarea;

import java.util.ArrayList;
import java.util.List;

public class BancoPreguntas 
{
	private String tema;
	private List<Pregunta> preguntas;
	
	public BancoPreguntas(String tema)
	{
		this.tema = tema;
		this.preguntas = new ArrayList<>();
	}
	
	public List<Pregunta> getPreguntas()
	{
		return preguntas;
	}
	
	public String getTema()
	{
		return tema;
	}
	
	public void agregarPregunta(String enunciado, String[] respuestas, int respuestaCorrecta)
    {
        Pregunta pregunta = new Pregunta(enunciado, respuestas, respuestaCorrecta);
        preguntas.add(pregunta);
    }
	
	public void agregarPregunta(Pregunta pregunta)
	{
		preguntas.add(pregunta);
	}
}
