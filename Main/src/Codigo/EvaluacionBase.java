package Codigo;

import java.util.List;
import java.util.Scanner;

public abstract class EvaluacionBase {
    protected BancoPreguntas banco;
    protected int puntuacion;

    public EvaluacionBase(BancoPreguntas banco) {
        this.banco = banco;
        this.puntuacion = 0;
    }

    public void realizarEvaluacion(Scanner entrada) throws RespuestaInvalidaException {
        List<Pregunta> preguntasEvaluacion = banco.getPreguntas();
        puntuacion = 0;
        for (Pregunta pregunta : preguntasEvaluacion) {
            System.out.println(pregunta.getEnunciado());
            String[] respuestas = pregunta.getRespuestas();
            for (int i = 0; i < respuestas.length; i++) {
                System.out.println((i + 1) + ") " + respuestas[i]);
            }
            boolean respuestaValida = false;
            while (!respuestaValida) {
                try {
                    System.out.println("Ingrese su respuesta (1 a 4): ");
                    int respuestaUsuario = entrada.nextInt();
                    if (respuestaUsuario < 1 || respuestaUsuario > 4) {
                        throw new RespuestaInvalidaException("Respuesta fuera de rango.");
                    }
                    respuestaValida = true;
                    if (pregunta.esCorrecta(respuestas[respuestaUsuario - 1])) {
                        incrementarPuntuacion();
                    }
                } catch (RespuestaInvalidaException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    entrada.next(); // Limpiar el scanner
                }
            }
        }
    }

    public abstract void incrementarPuntuacion();

    public int getPuntuacion() {
        return puntuacion;
    }
}
