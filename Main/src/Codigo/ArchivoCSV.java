package Codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArchivoCSV 
{
	private BufferedReader lector;
	private String linea;
	private String parte[] = null;
	
	public Set<String> leerMateriasCSV(String nombreArchivo)
	{
		Set<String> materias = new HashSet<>();
		try
		{
			lector = new BufferedReader(new FileReader(nombreArchivo));
			while ((linea = lector.readLine()) != null)
			{
				parte = linea.split(";");
				String asignatura = parte[0];
				materias.add(asignatura);
			}
			lector.close();
		}
		catch(Exception e){
			System.out.println("Error al leer las materias: " + e.getMessage());
		}
		return materias;
	}
	
	public void leerArchivoCSV(String nombreArchivo)
	{
		try
		{
			lector = new BufferedReader(new FileReader(nombreArchivo));
			while ((linea = lector.readLine()) != null)
			{
				parte = linea.split(";");
				String pregunta = parte[0];
                String respuesta1 = parte[1];
                String respuesta2 = parte[2];
                String respuesta3 = parte[3];
                String respuesta4 = parte[4];
                String respuestaValida = parte[5];
				System.out.println();
				System.out.println("Pregunta: " + pregunta);
				System.out.println(respuesta1);
				System.out.println(respuesta2);
				System.out.println(respuesta3);
				System.out.println(respuesta4);
				System.out.println("Respuesta: " + respuestaValida);
				System.out.println();
				System.out.println("------------------ o ------------------");
			}
			lector.close();
			linea = null;
			parte = null;
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public List<Pregunta> leerPreguntasCSV(String nombreArchivo) {
		List<Pregunta> preguntas = new ArrayList<>();
		try
		{
			lector = new BufferedReader(new FileReader(nombreArchivo));
			while ((linea = lector.readLine()) != null)
			{
				parte = linea.split(";");
				String pregunta = parte[0];
                String respuesta1 = parte[1];
                String respuesta2 = parte[2];
                String respuesta3 = parte[3];
                String respuesta4 = parte[4];
                String respuestaValida = parte[5];
				Pregunta nuevaPregunta = new Pregunta(pregunta, new String[]{respuesta1, respuesta2, respuesta3, respuesta4}, respuestaValida);
				preguntas.add(nuevaPregunta);
			}
			lector.close();
			linea = null;
			parte = null;
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
		return preguntas;
	}

	public static void guardarCambiosEnCSV(BancoPreguntas banco, String tema) {
        if (banco != null) {
            List<Pregunta> preguntas = banco.getPreguntas();
            String rutaCSV = "src/Preguntas/" + tema + ".csv"; // Ruta del archivo CSV
            
            // Sobreescribir el archivo CSV con las preguntas actuales
            try (FileWriter escritor = new FileWriter(rutaCSV)) {
                // Iterar sobre las preguntas y escribirlas en formato CSV
                for (Pregunta pregunta : preguntas) {
                    String enunciado = pregunta.getEnunciado();
                    String[] respuestas = pregunta.getRespuestas();
                    String respuestaCorrecta = pregunta.getRespuestaCorrecta();
                    
                    // Escribir cada pregunta en formato CSV
                    StringBuilder sb = new StringBuilder();
                    sb.append(enunciado).append(";");
                    
                    // Agregar las respuestas separadas por ";"
                    for (String respuesta : respuestas) {
                        sb.append(respuesta).append(";");
                    }
                    
                    // Agregar la respuesta correcta
                    sb.append(respuestaCorrecta).append("\n");
                    
                    // Escribir la pregunta completa en el archivo
                    escritor.write(sb.toString());
                }
                System.out.println("Cambios guardados exitosamente en el archivo CSV: " + tema + ".csv\n");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar los cambios en el archivo CSV.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Banco de preguntas no encontrado.");
        }
    }
}
