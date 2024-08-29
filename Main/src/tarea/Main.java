package tarea;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
	    int opcion = 0;
	    boolean salir = false;
	    opcion = entrada.nextInt();

	    while(!salir)
	    {
	    	System.out.println("1) INICIAR EVALUACIÓN\n2) REGISTRO DE NOTAS\n3) PRÁCTICA\n4) SOLUCIONARIO\n5) Salir");
	        System.out.println("Ingrese una opción: ");
	        opcion = entrada.nextInt();

	        switch(opcion)
	        {
	        	case 1:
	        		tarea.LimpiarPantalla.limpiarPantalla();
	            	System.out.println("| ---------- | Iniciar evaluación | ---------- |");
	            	tarea.LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 2:
	            	System.out.println("| ---------- | Registro de notas | ---------- | ");
	            	tarea.LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 3:
	            	System.out.println("| ---------- | Práctica | ---------- | ");
	            	tarea.LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 4:
	            	System.out.println("| ---------- | Solucionarío | ---------- | ");
	            	tarea.LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 5:
	            	System.out.println("Saliendo del programa...");
	            	salir = true;
	            	tarea.LimpiarPantalla.limpiarPantalla();
	            	break;

	            default:
	            	System.out.println("Ingrese una opción valida");
	        }
	    }
	    entrada.close();
	}
}
