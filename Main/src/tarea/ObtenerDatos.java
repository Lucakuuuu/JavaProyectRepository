package tarea;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
}
