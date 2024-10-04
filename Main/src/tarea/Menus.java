package tarea;

import java.util.List;
import java.util.Set;

public class Menus {
	public static void menuPrincipal() {
    	System.out.println("| ========== | MENÚ PRINCIPAL | ========== |\n"
    			+ "1) INICIAR EVALUACIÓN\n"
    			+ "2) REGISTRO DE NOTAS\n"
    			+ "3) PRÁCTICA\n"
    			+ "4) EXTRAS\n"
    			+ "5) SALIR\n"
    			+ "Ingrese una opción: ");
	}
	
	public static void menuPractica() {
    	System.out.println("\n| ---------- | PRÁCTICA | ---------- |\n"
    			+ "1) INICIAR PRÁCTICA\n"
    			+ "2) PUNTAJES OBTENIDOS\n"
    			+ "3) VOLVER AL MENÚ PRINCIPAL\n"
    			+ "Ingrese una opción: ");
	}

	public static void menuEvaluacion(Set<String> materias) {
		System.out.println("\n| ---------- | REALIZAR EVALUACIÓN | ---------- |\n"
    			+ "Materias:");
        for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba una materia de la que desea realizar una evaluación: ");
	}

	public static void menuRegistroNotas(Set<String> materias) {
		System.out.println("\n| ---------- | REGISTRO DE NOTAS OBTENIDAS | ---------- |\n"
				+ "Materias:");
		for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba la materia de la que desea ver las notas: ");
	}

	public static void subMenuPractica(Set<String> materias) {
		System.out.println("\n| ---------- | REALIZAR PRÁCTICA | ---------- |\n"
    			+ "Materias:");
		for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba una materia de la que desea realizar una práctica: ");
	}

	public static void subMenuRegistroPuntajes(Set<String> materias) {
		System.out.println("\n| ---------- | REGISTRO DE PUNTAJES OBTENIDOS | ---------- |\n"
				+ "Materias:");
		for (String puntaje : materias) System.out.println("- " + puntaje);
		System.out.println("- Salir\n"
        		+ "Escriba la materia de la que desea ver los puntajes obtenidos: ");
	}

	public static void menuSolucionario(Set<String> materias) {
		System.out.println("\n| ---------- | SOLUCIONARIO | ---------- |\n"
    			+ "Materias:");
		for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba la materia de la que desea ver el solucionario: ");
	}

	public static void menuExtras() {
		System.out.println("\n| ---------- | EXTRAS | ---------- |\n"
				+ "1) SOLUCIONARIO\n"
				+ "2) EDITOR DE PREGUNTAS\n"
				+ "3) VOLVER AL MENÚ PRINCIPAL\n"
				+ "Ingrese una opción: ");
	}

	public static void Editor() {
		System.out.println("\n| ---------- | EDITOR | ---------- |\n"
				+ "1) ELIMINAR PREGUNTA\n"
				+ "2) MODIFICAR PREGUNTA\n"
				+ "3) VOLVER AL MENÚ PRINCIPAL\n"
				+ "Ingrese una opción: ");
	}

	public static void EliminarPreguntas(Set<String> materias) {
		System.out.println("\n| ---------- | ELIMINAR PREGUNTAS | ---------- |\n"
    			+ "Materias:");
		for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba la materia de la que desea eliminar preguntas: ");
	}

	public static void ModificarPreguntas(Set<String> materias) {
		System.out.println("\n| ---------- | MODIFICAR PREGUNTAS | ---------- |\n"
    			+ "Materias:");
		for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba la materia de la que desea modificar preguntas: ");
	}
}
