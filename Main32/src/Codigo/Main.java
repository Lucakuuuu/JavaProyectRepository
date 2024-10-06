package Codigo;

import java.util.ArrayList;
import java.util.HashMap;
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
                    if (!temaSeleccionado1.equals("Salir")) {
                        BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado1);
                        if (bancoSeleccionado != null) {
                            System.out.println("Ingrese el nombre del estudiante: ");
                            String estudiante = entrada.next();
                            EvaluacionFormal evaluacionFormal = new EvaluacionFormal(bancoSeleccionado);
                            evaluacionFormal.realizarEvaluacionFormal(entrada);
                            Nota nuevaNota = new Nota(estudiante, temaSeleccionado1, evaluacionFormal.getPuntuacion(), bancoSeleccionado.getPreguntas().size());
                            registroNotas.add(nuevaNota);
                            System.out.println("Evaluación registrada correctamente.\n");
                        } else {
                            System.out.println("Tema no encontrado.\n");
                        }
                    } else {
                        System.out.println("Volviendo...\n");
                    }
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
	            	Menus.menuPractica();
                    String temaSeleccionado3 = entrada.next();
                    if (!temaSeleccionado3.equals("Salir")) {
                        BancoPreguntas materiaSeleccionado = bancosPorTema.get(temaSeleccionado3);
                        if (materiaSeleccionado != null) {
                            Practica practica = new Practica(materiaSeleccionado);
                            practica.realizarPractica(entrada);
                            Puntajes puntaje = new Puntajes(temaSeleccionado3, practica.getPuntuacion(), materiaSeleccionado.getPreguntas().size());
                            puntajesPracticas.add(puntaje);
                            System.out.println("Práctica registrada correctamente.\n");
                        } else {
                            System.out.println("Materia no encontrada.\n");
                        }
                    } else {
                        System.out.println("Volviendo...\n");
                    }
                    break;

	            case 4:
	            	// EXTRAS
	            	int salida1 = 0;
	            	while(salida1 == 0) {
	            		Menus.menuExtras();
		            	int opcion2 = entrada.nextInt();
		            	switch(opcion2) {
			            // MOSTRAR SOLUCIONARIO	
		            	case 1:
			            		 Menus.menuSolucionario(materias);
                                String temaSeleccionado4 = entrada.next();
                                if (!temaSeleccionado4.equals("Salir")) {
                                    BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado4);
                                    archivo.leerArchivoCSV("src/Preguntas/" + temaSeleccionado4 + ".csv");
                                    
                                    // Llamar a la clase GeneradorSolucionario para crear el archivo .txt
                                    GeneradorSolucionario.generarSolucionario(bancoSeleccionado, temaSeleccionado4);
                                } else {
                                    System.out.println("Volviendo... \n");
                                }
                                break;
				            	
			            // EDITOR DE PREGUNTAS	
		            	case 2:
			            		
			            		boolean salida2 = false;
			            		while(!salida2) {
			            			Menus.Editor();
			            			int opcion3 = entrada.nextInt();
			            			switch(opcion3) {
				            		// ELIMINAR PREGUNTA	
			            			case 1:
				            				Menus.EliminarPreguntas(materias);
				            				String temaSeleccionado6 = entrada.next();
				            				if(!temaSeleccionado6.equals("Salir")) {
				            					 BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado6);
	                                                if (bancoSeleccionado != null) {
	                                                    // Mostrar preguntas para que el usuario elija cuál eliminar
	                                                    List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();
	                                                    for (int i = 0; i < preguntas.size(); i++) {
	                                                        System.out.println((i + 1) + ". " + preguntas.get(i).getEnunciado());
	                                                    }

	                                                    System.out.println((preguntas.size()+1)+". Salir\n"+"Ingrese el número de la pregunta a eliminar: ");
	                                                    int indicePregunta = entrada.nextInt() - 1;
	                                                    if(!(preguntas.size() + 1 == indicePregunta)) break;
	                                                    if (indicePregunta >= 0 && indicePregunta < preguntas.size()) {
	                                                        Pregunta preguntaAEliminar = preguntas.get(indicePregunta);
	                                                        bancosPorTema = ObtenerDatos.eliminarPregunta(temaSeleccionado6, preguntaAEliminar, bancosPorTema);
	                                                        System.out.println("Pregunta eliminada exitosamente.");
	                                                    } else {
	                                                        System.out.println("Índice de pregunta inválido.");
	                                                    }
	                                                } else {
	                                                    System.out.println("Materia no encontrada.");
	                                                }
				            					
				            				}
				            				else System.out.println("Volviendo...");
				            				break;
				            				
				            		// MODIFICAR PREGUNTA	
			            			case 2:
				            				Menus.ModificarPreguntas(materias);
				            				String temaSeleccionado7 = entrada.next();
				            				if(!temaSeleccionado7.equals("Salir")) 
				            				{
				            					BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado7);
                                                if (bancoSeleccionado != null) {
                                                    System.out.println("Seleccione el número de la pregunta que desea modificar:");
                                                    List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();
                                                    for (int i = 0; i < preguntas.size(); i++) {
                                                        System.out.println((i + 1) + ". " + preguntas.get(i).getEnunciado());
                                                    }
                                                    System.out.println((preguntas.size()+1)+". Salir\n"+"Ingrese el número de la pregunta a eliminar: ");
                                                    int preguntaIndex = entrada.nextInt() - 1;
                                                    if(!(preguntas.size() + 1 == preguntaIndex)) break;
                                                    if (preguntaIndex >= 0 && preguntaIndex < preguntas.size()) {
                                                        Pregunta preguntaAModificar = preguntas.get(preguntaIndex);
                                                        ObtenerDatos.modificarPregunta(temaSeleccionado7, preguntaAModificar, bancosPorTema, entrada);
                                                    } else {
                                                        System.out.println("Índice de pregunta no válido.");
                                                    }
                                                } else {
                                                    System.out.println("Materia no encontrada.");
                                                }
				            				}
				            				else System.out.println("Volviendo...");
				            				break;
				            		// CERRAR
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
