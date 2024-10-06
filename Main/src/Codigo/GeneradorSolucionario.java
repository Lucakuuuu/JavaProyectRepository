package Codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorSolucionario {

    // Método para mapear letras a números
    private static int convertirLetraAIndice(String letra) {
        // Convertir la letra en mayúscula
        letra = letra.toUpperCase();

        // Mapear las letras a números
        switch (letra) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            default:
                throw new IllegalArgumentException("Respuesta inválida: " + letra);
        }
    }

    // Método para generar el archivo .txt con el solucionario
    public static void generarSolucionario(BancoPreguntas banco, String tema) {
        if (banco != null) {
            List<Pregunta> preguntas = banco.getPreguntas();
            
            // Crear el archivo .txt para el solucionario
            try (FileWriter escritor = new FileWriter(tema + "_solucionario.txt")) {
                escritor.write("Solucionario para el tema: " + tema + "\n\n");

                // Recorrer las preguntas y escribir la solución
                for (Pregunta pregunta : preguntas) {
                    escritor.write("Pregunta: " + pregunta.getEnunciado() + "\n");

                    // Convertir la respuesta correcta de letra a número
                    int indiceRespuestaCorrecta = convertirLetraAIndice(pregunta.getRespuestaCorrecta());
                    escritor.write("Respuesta correcta: " + pregunta.getRespuestas()[indiceRespuestaCorrecta] + "\n");
                    escritor.write("---------------------------------------\n");
                }
                System.out.println("Solucionario generado exitosamente en: " + tema + "_solucionario.txt\n");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al crear el archivo del solucionario.");
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.out.println("Error en las respuestas: " + e.getMessage());
            }
        } else {
            System.out.println("Materia no encontrada.\n");
        }
    }
}