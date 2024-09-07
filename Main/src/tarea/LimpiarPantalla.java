<<<<<<< HEAD
package tarea;

public class LimpiarPantalla{

    public static void limpiar() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
=======
package tarea;

public class LimpiarPantalla 
{
	 public static void limpiarPantalla()
	    {
	      System.out.print("\033[H\033[2J");
	      System.out.flush();
	    }
}
>>>>>>> 86e655e15bfc038b25100b9b18dbac929d38e38d
