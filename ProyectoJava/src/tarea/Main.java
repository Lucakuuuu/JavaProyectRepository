package tarea;
import java.util.Scanner;
/*
registro de bancos de preguntas por temas 
instancias de evaluación a partir de los bancos 
registro de notas de cada evaluación.

Lo que falta (avance):
  -Se debe hacer un menú para el Sistema donde ofrezca las funcionalidades de: 1) Inserción
   Manual / agregar elemento.
*/

public class Main 
{
  // print(HOLA, BIENEIDO AL SISTEMA DE EVALUACION POR ASINATURA, ingresa tu nombre);
  public static void main(String[] args) 
  {
    Scanner entrada = new Scanner(System.in);
    int opcion = 0;
    boolean salir = false;
    opcion = entrada.nextInt();
    
    System.out.println("| ---------- | Elija una opcion | ---------- |");

    while(!salir)
      {
        System.out.println("1) INICIAR EVALUACIÓN\n2) REGISTRO DE NOTAS\n3) PRÁCTICA\n4) SOLUCIONARIO\n5) Salir");
        System.out.println("Ingrese una opción: ");
        opcion = entrada.nextInt();

        switch(opcion)
          {
            case 1:
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