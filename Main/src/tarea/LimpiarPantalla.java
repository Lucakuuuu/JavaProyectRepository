package tarea;

public class LimpiarPantalla 
{
	 public static void limpiarPantalla()
	    {
	      System.out.print("\033[H\033[2J");
	      System.out.flush();
	    }
}
