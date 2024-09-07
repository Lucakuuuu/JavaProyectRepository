package tarea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		Map<String, BancoPreguntas> bancosPorTema = new HashMap<>();
		List<Nota> registroNotas = new ArrayList<>();
	    boolean salir = false;
	    ArchivoCSV archivo = new  ArchivoCSV();
	    
	    while(!salir)
	    {
	    	System.out.println("1) INICIAR EVALUACIÓN\n2) REGISTRO DE NOTAS\n3) PRÁCTICA\n4) SOLUCIONARIO\n5) Salir");
	        System.out.println("Ingrese una opción: ");
	        int opcion = entrada.nextInt();

	        switch(opcion)
	        {
	        	case 1:
	            	System.out.println("| ---------- | Seleccione Tema | ---------- |");
	            	for (String tema : bancosPorTema.keySet())
	            	{
	            		System.out.println("- " + tema);
	            	}
	            	String temaSeleccionado = entrada.next();
	            	BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado);
	            	if (bancoSeleccionado != null)
	            	{
	            		String estudiante = entrada.next();
	            		Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
	            		evaluacion.realizarEvaluacion();
	            		
	            		Nota nuevaNota = new Nota(estudiante, temaSeleccionado, evaluacion.getPuntuacion(), bancoSeleccionado.getPreguntas().size());
	            		registroNotas.add(nuevaNota);
	            		System.out.println("Evaluación registrada correctamente.");
	            	}
	            	else
	            	{
	            		System.out.println("Tema no encontrado. ");
	            	}
	            	System.out.println("| ---------------------------------------- |\n");
	            	break;

	            case 2:
	            	System.out.println("| ---------- | Registro de notas | ---------- | ");
	            	//LimpiarPantalla.limpiar();
	            	if(registroNotas.isEmpty())
	            	{
	            		System.out.println("No hay notas registradas. ");
	            	}
	            	else
	            	{
	            		for (Nota nota : registroNotas)
	            		{
	            			System.out.println(nota);
	            		}
	            	}
	            	System.out.println("| ---------------------------------------- |\n");
	            	break;

	            case 3:
	            	System.out.println("| ---------- | Práctica | ---------- | ");
	            	//LimpiarPantalla.limpiar();
	            	break;

	            case 4:
	            	System.out.println("| ---------- | Solucionarío | ---------- | ");
	            	//LimpiarPantalla.limpiar();
	            	archivo.leerArchivoCSV("C:\\Users\\ACER\\Desktop\\Libro1.csv");
	            	System.out.println("| ---------------------------------------- |\n");
	            	break;

	            case 5:
	            	System.out.println("Saliendo del programa...");
	            	salir = true;
	            	//LimpiarPantalla.limpiar();
	            	System.out.println("| ---------------------------------------- |\n");
	            	break;

	            default:
	            	System.out.println("Ingrese una opción valida");
	            	//LimpiarPantalla.limpiar();
	            	System.out.println("| ---------------------------------------- |\n");
	        }
	    }
	    entrada.close();
	}
}
