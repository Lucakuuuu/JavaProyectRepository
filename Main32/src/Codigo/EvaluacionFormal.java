package Codigo;

import java.util.Scanner;

public class EvaluacionFormal extends EvaluacionBase {

    public EvaluacionFormal(BancoPreguntas banco) {
        super(banco);
    }

    @Override
    public void incrementarPuntuacion() {
        this.puntuacion += 1; // Incrementa de 1 en 1
    }

    public void realizarEvaluacionFormal(Scanner entrada) {
        try {
            realizarEvaluacion(entrada);
        } catch (RespuestaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
