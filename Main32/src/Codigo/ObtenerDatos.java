package Codigo;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ObtenerDatos {
	
	public static Map<String, BancoPreguntas> cargarMaterias(String carpetaPreguntas, Set<String> materias, Map<String, BancoPreguntas> bancosPorTema) {
		for (String materia : materias)
    	{
			String RutaCSV = "src/Preguntas/" + materia + ".csv";
			ArchivoCSV archivo = new ArchivoCSV();
			List<Pregunta> preguntas = archivo.leerPreguntasCSV(RutaCSV);
			BancoPreguntas informacion = new BancoPreguntas(materia, preguntas);
			bancosPorTema.put(materia, informacion);
    	}
		return bancosPorTema;
	}
	
	public static Set<String> obtenerMateriasDesdeCarpeta(String carpeta)
    {
        Set<String> materias = new HashSet<>();
        File folder = new File(carpeta);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".csv")) {
                    String materia = file.getName().replace(".csv", "");
                    materias.add(materia);
                }
            }
        } else {
            System.out.println("La carpeta no contiene archivos.");
        }
        return materias;
    }
	public static Map<String, BancoPreguntas> eliminarPregunta(String materia, Pregunta preguntaAEliminar, Map<String, BancoPreguntas> bancosPorTema) {
        if (bancosPorTema.containsKey(materia)) {
            BancoPreguntas banco = bancosPorTema.get(materia);
            List<Pregunta> preguntas = banco.getPreguntas();

            if (preguntas.remove(preguntaAEliminar)) {
                System.out.println("La pregunta fue eliminada correctamente.");
            } else {
                System.out.println("La pregunta no se encontró en el banco de preguntas.");
            }
        } else {
            System.out.println("La materia no existe en el sistema.");
        }
        return bancosPorTema;
    }
	
	 public static void modificarPregunta(String materia, Pregunta preguntaAModificar, Map<String, BancoPreguntas> bancosPorTema, Scanner entrada) {
	        if (bancosPorTema.containsKey(materia)) {
	            BancoPreguntas banco = bancosPorTema.get(materia);
	            List<Pregunta> preguntas = banco.getPreguntas(); // Asumiendo que hay un getter para obtener la lista de preguntas

	            if (preguntas.contains(preguntaAModificar)) {
	                System.out.println("Ingrese el nuevo enunciado: ");
	                entrada.nextLine();  // Consumir la nueva línea pendiente
	                String nuevoEnunciado = entrada.nextLine();

	                System.out.println("Ingrese las nuevas alternativas separadas por comas (ej: opción1, opción2, opción3, opción4): ");
	                String alternativas = entrada.nextLine();
	                String[] nuevasRespuestas = alternativas.split(",\\s*");  // Divide la entrada por comas

	                System.out.println("Ingrese la nueva respuesta correcta: ");
	                String nuevaRespuestaCorrecta = entrada.nextLine();

	                // Modificamos los valores de la pregunta
	                preguntaAModificar.setEnunciado(nuevoEnunciado);
	                preguntaAModificar.setRespuestas(nuevasRespuestas);
	                preguntaAModificar.setRespuestaCorrecta(nuevaRespuestaCorrecta);

	                System.out.println("La pregunta ha sido modificada exitosamente.");
	            } else {
	                System.out.println("La pregunta no se encuentra en el banco de preguntas.");
	            }
	        } else {
	            System.out.println("La materia no existe en el sistema.");
	        }
	    }
}
	

