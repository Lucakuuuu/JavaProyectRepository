package tarea;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main 
{
	public static void main(String[] args) 
	{
		Scanner entrada = new Scanner(System.in);
		Map<String, BancoPreguntas> bancosPorTema = new HashMap<>();
		List<Nota> registroNotas = new ArrayList<>();
		List<Puntajes> puntajesPracticas = new ArrayList<>();
	    boolean salir = false;
	    
	    ArchivoCSV archivo = new  ArchivoCSV();
	    String carpetaPreguntas = "src/Preguntas/";
	    Set<String> materias = ObtenerDatos.obtenerMateriasDesdeCarpeta(carpetaPreguntas);
	    bancosPorTema = ObtenerDatos.cargarMaterias(carpetaPreguntas, materias, bancosPorTema);
	    
	    while(!salir)
	    {
	    	Menus.menuPrincipal();
	        int opcion1 = entrada.nextInt();
	        switch(opcion1)
	        {
	        // EVALUACION
            case 1:
            	Menus.menuEvaluacion(materias);
            	String temaSeleccionado1 = entrada.next();
	            if(!temaSeleccionado1.equals("Salir")) {
	            	BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado1);
			        if (bancoSeleccionado != null){
			        	System.out.println("Ingrese el nombre del estudiante: ");
			        	String estudiante = entrada.next();
			            Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
			           	evaluacion.realizarEvaluacion(entrada, bancosPorTema);
			           	Nota nuevaNota = new Nota(estudiante, temaSeleccionado1, evaluacion.getPuntuacion(), bancoSeleccionado.getPreguntas().size());
			           	registroNotas.add(nuevaNota);
			           	System.out.println("Evaluación registrada correctamente.\n");
			        }
			        else System.out.println("Tema no encontrado.\n");
	            }
	            else System.out.println("Volviendo... \n");
	            break;

	            case 2:
	            	// REGISTRO DE NOTAS
	            	if(registroNotas.isEmpty()) System.out.println("No hay notas registradas.\n");
	            	else
	            	{
	            		int salida = 0;
		            	while(salida == 0) {
		            		Menus.menuRegistroNotas(materias);
			                String temaSeleccionado2 = entrada.next();
			                if(!temaSeleccionado2.equals("Salir")) {
			                	List<Nota> notas = new ArrayList<>();
			                	for (Nota nota : registroNotas) if(temaSeleccionado2.equals(nota.getTema())) notas.add(nota);
			                	if(notas.size() == 0) System.out.println("No hay notas registradas para este tema...");
			                	else
			                		for(Nota nota : notas)
			                			System.out.println("---------------- o -----------------\n"
				            					+ nota);
			                }
			                else {
			                	System.out.println("Volviendo al menú principal...\n");
			            		salida = 1;
			                }
		            	}
		            	System.out.println("\n");
	            	}
	            	break;

	            case 3:
	            	// PRACTICA
	            	int salida = 0;
	            	while(salida == 0) {
	            		Menus.menuPractica();
		            	int opcion2 = entrada.nextInt();
		            	switch(opcion2){
		            	case 1:
		            		Menus.subMenuPractica(materias);
			                String temaSeleccionado3 = entrada.next();
			                if(!temaSeleccionado3.equals("Salir")) {
			                	BancoPreguntas materiaSeleccionado = bancosPorTema.get(temaSeleccionado3);
				                if (materiaSeleccionado != null){
						           	Evaluacion evaluacion = new Evaluacion(materiaSeleccionado);
						           	evaluacion.realizarPractica(entrada, bancosPorTema);
						           	Puntajes puntaje = new Puntajes(temaSeleccionado3, evaluacion.getPuntuacion(), materiaSeleccionado.getPreguntas().size());
						           	puntajesPracticas.add(puntaje);
						           	System.out.println("Práctica registrada correctamente.\n");
				                }
					            else System.out.println("Materia no encontrada.\n");
			                }
			                else System.out.println("Volviendo... ");
		            		break;
		            		
		            	case 2:
			            	if(puntajesPracticas.isEmpty()) System.out.println("No hay puntajes registrados.");
			            	else {
			            		int salida1 = 0;
				            	while(salida1 == 0) {
				            		Menus.subMenuRegistroPuntajes(materias);
					            	String temaSeleccionado5 = entrada.next();
					                if(!temaSeleccionado5.equals("Salir")) {
					                	List<Puntajes> puntajes = new ArrayList<>();
					                	for (Puntajes puntaje : puntajesPracticas) if(temaSeleccionado5.equals(puntaje.getMateria())) puntajes.add(puntaje);
					                	if(puntajes.size() == 0) System.out.println("No hay notas registradas para este tema...");
					                	else
					                		for(Puntajes puntaje : puntajes)
					                			System.out.println("---------------- o -----------------\n"
						            					+ puntaje);
					                }
					                else {
					                	System.out.println("Volviendo...");
					            		salida1 = 1;
					                }
				            	}
			            	}
		            		break;
		            		
		            	case 3:
		            		System.out.println("Volviendo al menú principal...\n");
		            		salida = 1;
		            		break;
		            	}
	            	}
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 4:
	            	// EXTRAS
	            	int salida1 = 0;
	            	while(salida1 == 0) {
	            		Menus.menuExtras();
		            	int opcion2 = entrada.nextInt();
		            	switch(opcion2) {
			            	case 1:
			            		Menus.menuSolucionario(materias);
				                String temaSeleccionado4 = entrada.next();
				                if(!temaSeleccionado4.equals("Salir")) {
					            	String rutaCSV = "src/Preguntas/" + temaSeleccionado4 + ".csv";
					            	archivo.leerArchivoCSV(rutaCSV);
				                }
				                else System.out.println("Volviendo... \n");
				            	break;
				            	
			            	case 2:
			            		boolean salida2 = false;
			            		while(!salida2) {
			            			Menus.Editor();
			            			int opcion3 = entrada.nextInt();
			            			switch(opcion3) {
				            			case 1:
				            				Menus.EliminarPreguntas(materias);
				            				String temaSeleccionado6 = entrada.next();
				            				if(!temaSeleccionado6.equals("Salir")) {
				            					
				            				}
				            				else System.out.println("Volviendo...");
				            				break;
				            				
				            			case 2:
				            				Menus.ModificarPreguntas(materias);
				            				String temaSeleccionado7 = entrada.next();
				            				if(!temaSeleccionado7.equals("Salir")) {
				            					
				            				}
				            				else System.out.println("Volviendo...");
				            				break;
				            				
				            			case 3:
				            				System.out.println("Volviendo... \n");
				            				salida2 = true;
				            				break;
				            				
			            			}
			            		}
			            		
			            	case 3:
			            		System.out.println("Volviendo al menú principal...\n");
			            		salida1 = 1;
			            		break;
		            	}
	            	}
	            	break;

	            case 5:
	            	System.out.println("Saliendo del programa...");
	            	salir = true;
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            default:
	            	System.out.println("Ingrese una opción valida\n");
	        }
	    }
	    entrada.close();
	}
}
