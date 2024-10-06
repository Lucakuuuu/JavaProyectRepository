package Codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorSolucionario {

    public static void generarSolucionario(BancoPreguntas banco, String tema) 
    {
        if (banco != null) {
            List<Pregunta> preguntas = banco.getPreguntas();
            
            // Crear el archivo .txt para el solucionario
            try (FileWriter escritor = new FileWriter(tema + "_solucionario.txt")) 
            {
                escritor.write("Solucionario para el tema: " + tema + "\n\n");

                // Recorrer las preguntas y escribir la solución
                for (Pregunta pregunta : preguntas) 
                {
                    escritor.write("Pregunta: " + pregunta.getEnunciado() + "\n");
                    escritor.write("Respuesta correcta: " + pregunta.getRespuestas()[Integer.parseInt(pregunta.getRespuestaCorrecta()) - 1] + "\n");
                    escritor.write("---------------------------------------\n");
                }
                System.out.println("Solucionario generado exitosamente en: " + tema + "_solucionario.txt\n");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al crear el archivo del solucionario.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Materia no encontrada.\n");
        }
    }
}
