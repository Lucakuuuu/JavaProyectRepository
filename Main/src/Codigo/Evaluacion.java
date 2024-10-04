package Codigo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Evaluacion {
    private BancoPreguntas banco;
    private int puntuacion;

    public Evaluacion(BancoPreguntas banco) {
        this.banco = banco;
        this.puntuacion = 0;
    }

    public void realizarEvaluacion(Scanner entrada2, Map<String, BancoPreguntas> bancosPorTema) {
        puntuacion = 0;
        List<Pregunta> preguntasEvaluacion = banco.getPreguntas();
        int totalPreguntas = preguntasEvaluacion.size();
        int numero = 1;
        for (Pregunta pregunta : preguntasEvaluacion) {
        	
        	System.out.println("\nPREGUNTA "+numero);
            System.out.println(pregunta.getEnunciado());
            String[] respuestas = pregunta.getRespuestas();
            for (int i = 0; i < respuestas.length; i++) System.out.println((i + 1) + ") " + respuestas[i]);
            
            System.out.println("Ingrese su respuesta: ");
            String respuestaUsuario = entrada2.next();
            if (pregunta.esCorrecta(respuestaUsuario)) puntuacion++;
            
            numero++;
            System.out.println("---------------- o -----------------");
        }
        System.out.println("Evaluación completa\n"
        		+ "Puntuación: " + puntuacion + " de " + totalPreguntas);
    }
    
    public void realizarPractica(Scanner entrada2, Map<String, BancoPreguntas> bancosPorTema) {
        puntuacion = 0;
        List<Pregunta> preguntasEvaluacion = banco.getPreguntas();
        int totalPreguntas = preguntasEvaluacion.size();
        int numero = 1;
        for (Pregunta pregunta : preguntasEvaluacion) {
        	
        	System.out.println("\nPREGUNTA "+numero);
            System.out.println(pregunta.getEnunciado());
            String[] respuestas = pregunta.getRespuestas();
            for (int i = 0; i < respuestas.length; i++) System.out.println((i + 1) + ") " + respuestas[i]);
            
            System.out.println("Ingrese su respuesta: ");
            String respuestaUsuario = entrada2.next();
            if (pregunta.esCorrecta(respuestaUsuario)) puntuacion++;
            
            numero++;
            System.out.println("---------------- o -----------------");
        }
        System.out.println("Práctica completada.\n"
        		+ "Puntuación: " + puntuacion + " de " + totalPreguntas);
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    
    public BancoPreguntas getBanco() {
    	return banco;
    }
    
    public void incrementarPuntuacion() {
    	this.puntuacion += 1;
    }
}
