package tarea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
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
		catch(Exception e)
		{
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
				String asignatura = parte[0];
				String tema = parte[1];
				String pregunta = parte[2];
				String respuesta1 = parte[3];
				String respuesta2 = parte[4];
				String respuesta3 = parte[5];
				String respuesta4 = parte[6];
				String respuestaValida = parte[7];
				System.out.println();
				System.out.println("Asignatura: " + asignatura);
				System.out.println("Tema: " + tema);
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
		}catch(Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
