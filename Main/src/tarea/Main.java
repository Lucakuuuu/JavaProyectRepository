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
	    Set<String> materias = obtenerMateriasDesdeCarpeta(carpetaPreguntas);
	    bancosPorTema = cargarMaterias(carpetaPreguntas, materias, bancosPorTema);
	    
	    while(!salir)
	    {
	    	Menus.menuPrincipal();
	        int opcion1 = entrada.nextInt();
	        switch(opcion1)
	        {
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
	            	if(registroNotas.isEmpty()) System.out.println("No hay notas registradas.\n");
	            	else
	            	{
	            		Menus.menuRegistroNotas(materias);
		                String temaSeleccionado2 = entrada.next();
		                if(!temaSeleccionado2.equals("Salir")) {
		                	for (Nota nota : registroNotas)
			            		if(temaSeleccionado2.equals(nota.getTema()))
			            			System.out.println("---------------- o -----------------\n"
			            					+ nota);
		                }
		                System.out.println("\n");
	            	}
	            	break;

	            case 3:
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
						           	Puntajes puntaje = new Puntajes(temaSeleccionado3, evaluacion.getPuntuacion());
						           	puntajesPracticas.add(puntaje);
						           	System.out.println("Práctica registrada correctamente.\n");
				                }
					            else System.out.println("Materia no encontrada.\n");
			                }
			                else System.out.println("Volviendo... \n");
		            		break;
		            		
		            	case 2:
			            	if(puntajesPracticas.isEmpty()) System.out.println("No hay puntajes registrados.");
			            	else
			            		Menus.subMenuRegistroPuntajes(puntajesPracticas);
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
	            	Menus.menuSolucionario(materias);
	                String temaSeleccionado4 = entrada.next();
	                if(!temaSeleccionado4.equals("Salir")) {
		            	String rutaCSV = "src/Preguntas/" + temaSeleccionado4 + ".csv";
		            	archivo.leerArchivoCSV(rutaCSV);
	                }
	                else System.out.println("Volviendo... \n");
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
	
	private static Map<String, BancoPreguntas> cargarMaterias(String carpetaPreguntas, Set<String> materias, Map<String, BancoPreguntas> bancosPorTema) {
		for (String materia : materias)
    	{
			String RutaCSV = "src/Preguntas/" + materia + ".csv";
			ArchivoCSV archivo = new ArchivoCSV();
			List<Pregunta> preguntas = archivo.leerPreguntasCSV(RutaCSV);
			BancoPreguntas informacion = new BancoPreguntas(materia, preguntas);
			bancosPorTema.put(materia, informacion);
    	}
		return bancosPorTema;
	}

	private static Set<String> obtenerMateriasDesdeCarpeta(String carpeta)
    {
        Set<String> materias = new HashSet<>();
        File folder = new File(carpeta);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".csv")) {
                    String materia = file.getName().replace(".csv", "");
                    materias.add(materia);
                }
            }
        } else {
            System.out.println("La carpeta no contiene archivos.");
        }
        return materias;
    }
}
