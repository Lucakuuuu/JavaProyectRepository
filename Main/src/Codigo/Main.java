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
                                                        String nuevoEnunciado;
                                                        String[] nuevasRespuestas;
                                                        String nuevaRespuestaCorrecta;
                                                        if (preguntas.contains(preguntaAModificar)) {
                                                            System.out.println("Ingrese el nuevo enunciado: ");
                                                            entrada.nextLine();  // Consumir la nueva línea pendiente
                                                            nuevoEnunciado = entrada.nextLine();

                                                            System.out.println("Ingrese las nuevas alternativas separadas por comas (ej: opción1, opción2, opción3, opción4): ");
                                                            String alternativas = entrada.nextLine();
                                                            nuevasRespuestas = alternativas.split(",\\s*");  // Divide la entrada por comas

                                                            System.out.println("Ingrese la nueva respuesta correcta: ");
                                                            nuevaRespuestaCorrecta = entrada.nextLine();
                                                            bancosPorTema = ObtenerDatos.modificarPregunta(temaSeleccionado7, preguntaAModificar, nuevoEnunciado, nuevasRespuestas,
                                                            		nuevaRespuestaCorrecta, bancosPorTema);
                                                        }
                                                        else {
                                                            System.out.println("La pregunta no se encuentra en el banco de preguntas.");
                                                        }
                                                    } else {
                                                        System.out.println("Índice de pregunta no válido.");
                                                    }
                                                } else {
                                                    System.out.println("Materia no encontrada.");
                                                }
				            				}
				            				else System.out.println("Volviendo...");
				            				break;

				            		// AGREGAR PREGUNTAS
									case 3:
											Menus.menuAgregarPreguntas(materias);	
	                                		String temaSeleccionado8 = entrada.next();
	                                		if (!temaSeleccionado8.equals("Salir")) {
	                                            // Recibir la nueva pregunta del usuario
	                                            System.out.println("Ingrese el enunciado de la nueva pregunta:");
	                                            entrada.nextLine();  // Consumir la nueva línea
	                                            String enunciado = entrada.nextLine();

	                                            System.out.println("Ingrese las opciones de respuesta (separadas por coma):");
	                                            String[] respuestas = entrada.nextLine().split(",");

	                                            System.out.println("Ingrese el número de la respuesta correcta (1-" + respuestas.length + "):");
	                                            int respuestaCorrecta = entrada.nextInt();
	                                            String[] Respuestas = {"A", "B", "C", "D"};
	                                            bancosPorTema = ObtenerDatos.agregarPregunta(temaSeleccionado8, enunciado, respuestas, Respuestas[respuestaCorrecta-1], bancosPorTema);
											} else {
												System.out.println("Volviendo...");
	                                		}
	                                		break;
				            		// CERRAR
				            		case 4:
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
	            	break;

	            default:
	            	System.out.println("Ingrese una opción valida\n");
	        }
	    }
	    entrada.close();
	}
}
