package tarea;

import java.util.List;
import java.util.Set;

public class Menus {
	public static void menuPrincipal() {
    	System.out.println("| ========== | MENÚ PRINCIPAL | ========== |\n"
    			+ "1) INICIAR EVALUACIÓN\n"
    			+ "2) REGISTRO DE NOTAS\n"
    			+ "3) PRÁCTICA\n"
    			+ "4) SOLUCIONARIO\n"
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
		System.out.println("\n| ---------- | REGISTRO DE NOTAS | ---------- |\n"
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

	public static void subMenuRegistroPuntajes(List<Puntajes> puntajesPracticas) {
		for (Puntajes puntaje : puntajesPracticas) System.out.println(puntaje);
	}

	public static void menuSolucionario(Set<String> materias) {
		System.out.println("\n| ---------- | SOLUCIONARIO | ---------- |\n"
    			+ "Materias:");
		for (String materia : materias) System.out.println("- " + materia);
        System.out.println("- Salir\n"
        		+ "Escriba la materia de la que desea ver el solucionario: ");
	}
}
