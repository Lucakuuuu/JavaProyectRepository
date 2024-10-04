package Codigo;

import java.util.*;

public class BancoPreguntas 
{
	private String tema;
	private List<Pregunta> preguntas;
	
	public BancoPreguntas(String tema, List<Pregunta> preguntas)
	{
		this.tema = tema;
		this.preguntas = preguntas;
	}
	
	public void agregarPregunta(Pregunta pregunta)
	{
		preguntas.add(pregunta);
	}
	
	public List<Pregunta> getPreguntas()
	{
		return preguntas;
	}
	
	public String getTema()
	{
		return tema;
	}
}
