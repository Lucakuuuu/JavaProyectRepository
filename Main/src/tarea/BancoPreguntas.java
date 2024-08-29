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
