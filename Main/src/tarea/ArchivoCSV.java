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
				imprimirLinea();
				System.out.println();
			}
			lector.close();
			linea = null;
			parte = null;
		}catch(Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void imprimirLinea()
	{
		for (int i = 0 ; i < parte.length ; i++)
		{
			System.out.println(parte[i] + " | ");
		}
	}
}
