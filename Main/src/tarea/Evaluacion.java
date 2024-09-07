package tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evaluacion 
{
	private BancoPreguntas banco;
	private List<Pregunta> preguntasEvaluacion;
	private int puntuacion;
	
	public Evaluacion(BancoPreguntas banco)
	{
		this.banco = banco;
		this.preguntasEvaluacion = new ArrayList<>(banco.getPreguntas());
		this.puntuacion = 0;
	}
	
	public void realizarEvaluacion()
	{
		Scanner entrada = new Scanner(System.in);
		for (Pregunta pregunta : preguntasEvaluacion)
		{
			System.out.println(pregunta.getEnunciado());
			String[] respuestas = pregunta.getRespuestas();
			for (int i = 0 ; i < respuestas.length ; i++)
			{
				System.out.println((i + 1) + ") " + respuestas[i]);
			}
			System.out.println("ingrese su respuesta: ");
			int respuestaUsuario = entrada.nextInt() - 1;
			
			if (pregunta.esCorrecta(respuestaUsuario))
			{
				puntuacion++;
			}
			entrada.close();
			}
		System.out.println("Evaluación completa. Puntuación: " + puntuacion + " de " + preguntasEvaluacion.size());
	}
	
	public int getPuntuacion()
	{
		return puntuacion;
	}
}
