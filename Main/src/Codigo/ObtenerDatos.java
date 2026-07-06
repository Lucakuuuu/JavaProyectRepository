package Codigo;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ObtenerDatos {
    
    // Cargar las materias desde la carpeta de preguntas
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

    // Obtener las materias desde la carpeta
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

    // Eliminar una pregunta y guardar los cambios en el CSV
    public static Map<String, BancoPreguntas> eliminarPregunta(String materia, Pregunta preguntaAEliminar, Map<String, BancoPreguntas> bancosPorTema) {
        if (bancosPorTema.containsKey(materia)) {
            BancoPreguntas banco = bancosPorTema.get(materia);
            List<Pregunta> preguntas = banco.getPreguntas();

            if (preguntas.remove(preguntaAEliminar)) {
                System.out.println("La pregunta fue eliminada correctamente.");
                ArchivoCSV.guardarCambiosEnCSV(banco, materia);
            } else {
                System.out.println("La pregunta no se encontró en el banco de preguntas.");
            }
        } else {
            System.out.println("La materia no existe en el sistema.");
        }
        return bancosPorTema;
    }

    // Modificar una pregunta y guardar los cambios en el CSV
    public static Map<String, BancoPreguntas> modificarPregunta(String materia, Pregunta preguntaAModificar, String nuevoEnunciado, String[] nuevasRespuestas, String nuevaRespuestaCorrecta, Map<String, BancoPreguntas> bancosPorTema) {
    	Scanner entrada = new Scanner(System.in);;
        if (bancosPorTema.containsKey(materia)) {
            BancoPreguntas banco = bancosPorTema.get(materia);
            List<Pregunta> preguntas = banco.getPreguntas();

                // Modificamos los valores de la pregunta
                preguntaAModificar.setEnunciado(nuevoEnunciado);
                preguntaAModificar.setRespuestas(nuevasRespuestas);
                preguntaAModificar.setRespuestaCorrecta(nuevaRespuestaCorrecta);

                System.out.println("La pregunta ha sido modificada exitosamente.");

                ArchivoCSV.guardarCambiosEnCSV(banco, materia);
            } else {
            System.out.println("La materia no existe en el sistema.");
        }
        return bancosPorTema;
    }
    
    public static void modificarPregunta(String materia, Pregunta preguntaAModificar, Map<String, BancoPreguntas> bancosPorTema, Scanner entrada) {
        if (bancosPorTema.containsKey(materia)) {
            BancoPreguntas banco = bancosPorTema.get(materia);
            List<Pregunta> preguntas = banco.getPreguntas();
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

                // Guardar los cambios en el archivo CSV
                ArchivoCSV.guardarCambiosEnCSV(banco, materia);
            } else {
                System.out.println("La pregunta no se encuentra en el banco de preguntas.");
            }
        } else {
            System.out.println("La materia no existe en el sistema.");
        }
    }

    public static Map<String, BancoPreguntas> agregarPregunta(String tema, String enunciado, String[] respuestas, String RespuestaCorrecta, Map<String, BancoPreguntas> bancosPorTema) {
        BancoPreguntas bancoPreguntas = bancosPorTema.get(tema);
        Scanner entrada = new Scanner(System.in);;
        if (bancoPreguntas != null) {

            // Crear una nueva pregunta
            Pregunta nuevaPregunta = new Pregunta(enunciado, respuestas, RespuestaCorrecta);
            bancoPreguntas.agregarPregunta(nuevaPregunta);

            // Agregar la pregunta al archivo CSV
            String archivoCSV = "src/Preguntas/" + tema + ".csv";
            try (FileWriter fileWriter = new FileWriter(archivoCSV, true);  // 'true' es para adjuntar, no sobrescribir
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {

                // Agregar la nueva pregunta al archivo CSV
                printWriter.println(enunciado + ";" + String.join(";", respuestas) + ";" + RespuestaCorrecta+";");
                System.out.println("Pregunta añadida correctamente al archivo.");

            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
            }
        }
		return bancosPorTema;
    }
}
