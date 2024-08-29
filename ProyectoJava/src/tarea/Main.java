package tarea;
import java.util.*;

public class Main 
{
  public static void main(String[] args) 
  {
    Scanner entrada = new Scanner(System.in);
    int opcion = 0;
    boolean salir = false;

    ArrayList<Asignatura> lista = new ArrayList<>();

    for(int i = 0; i < 3; i++) {
    	System.out.println("Ingrese la asignatura: ");
    	String nombre = entrada.nextLine();
    	Asignatura asignatura = new Asignatura(nombre, i+1);
    	lista.add(asignatura);
    }
    
    System.out.println("| ---------- | Elija una opción | ---------- |");

    while(!salir) 
    {
      System.out.println("1) INICIAR EVALUACIÓN\n2) REGISTRO DE NOTAS\n3) PRÁCTICA\n4) SOLUCIONARIO\n5) Salir");
      System.out.println("Ingrese una opción: ");
      opcion = entrada.nextInt();

      switch(opcion) {
        case 1:
          System.out.println("| ---------- | Iniciar evaluación | ---------- |");
          tarea.LimpiarPantalla.limpiarPantalla();
          break;

        case 2:
          System.out.println("| ---------- | Registro de notas | ---------- | ");
          for(int j = 0; j < lista.size(); j++) {
        	  lista.get(j).mostrarAsignatura();
          }
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
