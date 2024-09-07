package tarea;
import java.io.BufferedReader;
import java.io.FileReader;



public class ArchivoCSV 
{
	private BufferedReader lector;
	private String linea;
	private String parte[] = null;
	
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
				System.out.println();
				System.out.println("Pregunta: " + pregunta);
				System.out.println("1) " + respuesta1);
				System.out.println("2) " + respuesta2);
				System.out.println("3) " + respuesta3);
				System.out.println("4) " + respuesta4);
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
