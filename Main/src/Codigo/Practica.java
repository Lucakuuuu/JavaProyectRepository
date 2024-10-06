package Codigo;

import java.util.Scanner;

public class Practica extends EvaluacionBase {

    public Practica(BancoPreguntas banco) {
        super(banco);
    }

    @Override
    public void incrementarPuntuacion() {
        this.puntuacion += 2; 
    }

    public void realizarPractica(Scanner entrada) {
        try {
            realizarEvaluacion(entrada);
        } catch (RespuestaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
