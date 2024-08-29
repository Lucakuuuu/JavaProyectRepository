package tarea;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		Map<String, BancoPreguntas> bancosPorTema = new HashMap<>();
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
	            		Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
	            		evaluacion.realizarEvaluacion();
	            	}
	            	else
	            	{
	            		System.out.println("Tema no encontrado. ");
	            	}
	            	break;

	            case 2:
	            	System.out.println("| ---------- | Registro de notas | ---------- | ");
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 3:
	            	System.out.println("| ---------- | Práctica | ---------- | ");
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 4:
	            	System.out.println("| ---------- | Solucionarío | ---------- | ");
	            	LimpiarPantalla.limpiarPantalla();
	            	archivo.leerArchivoCSV("C:\\Users\\jicc\\Desktop\\Libro1.csv");	
	            	
	            	break;

	            case 5:
	            	System.out.println("Saliendo del programa...");
	            	salir = true;
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            default:
	            	System.out.println("Ingrese una opción valida");
	        }
	    }
	    entrada.close();
	}
}
