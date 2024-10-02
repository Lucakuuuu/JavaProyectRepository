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
	    
	    while(!salir)
	    {
	    	Menus.menuPrincipal();
	        int opcion1 = entrada.nextInt();
	        switch(opcion1)
	        {
            case 1:
	            	System.out.println("\n| ---------- | EVALUACIÓN | ---------- |\n"
	            			+ "Materias:");
	            	
	                Set<String> materias = obtenerMateriasDesdeCarpeta(carpetaPreguntas);
	                for (String materia : materias)
	                {
	                    System.out.println("- " + materia);
	                }
	                System.out.println("Escriba una opción una materia: ");
	                String temaSeleccionado = entrada.next();
	            	BancoPreguntas bancoSeleccionado = bancosPorTema.get(temaSeleccionado);
	            	if (bancoSeleccionado != null)
	            	{
	            		String estudiante = entrada.next();
	            		Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
	            		evaluacion.realizarEvaluacion();
	            		
	            		Nota nuevaNota = new Nota(estudiante, temaSeleccionado, evaluacion.getPuntuacion(), bancoSeleccionado.getPreguntas().size());
	            		registroNotas.add(nuevaNota);
	            		System.out.println("Evaluación registrada correctamente.");
	            	}
	            	else
	            	{
	            		System.out.println("Tema no encontrado. ");
	            	}
	            	break;

	            case 2:
	            	System.out.println("| ---------- | Registro de notas | ---------- | ");
	            	LimpiarPantalla.limpiarPantalla();
	            	if(registroNotas.isEmpty())
	            	{
	            		System.out.println("No hay notas registradas. ");
	            	}
	            	else
	            	{
	            		for (Nota nota : registroNotas){
	            			System.out.println(nota);
	            		}
	            	}
	            	break;

	            case 3:
	            	System.out.println("\n| ---------- | Práctica | ---------- | ");
	            	Menus.menuPractica();
	            	int salida = 0;
	            	while(salida == 0) {
		            	int opcion2 = entrada.nextInt();
		            	switch(opcion2){
		            	case 1:
			            	for (String tema : bancosPorTema.keySet())
			            	{
			            		System.out.println("- " + tema);
			            	}
			            	String materiaSeleccionada = entrada.next();
			            	BancoPreguntas materiaSeleccionado = bancosPorTema.get(materiaSeleccionada);
			            	if (materiaSeleccionado != null)
			            	{
			            		Evaluacion evaluacion = new Evaluacion(materiaSeleccionado);
			            		evaluacion.realizarEvaluacion();
			            		Puntajes puntaje = new Puntajes(materiaSeleccionada, evaluacion.getPuntuacion());
			            		puntajesPracticas.add(puntaje);
			            		System.out.println("Práctica realizada.\n"
			            				+ "Tu puntaje fue: "+ puntaje.getPuntaje());
			            	}
			            	else
			            	{
			            		System.out.println("Materia no encontrada. ");
			            	}
		            		break;
		            		
		            	case 2:
			            	if(puntajesPracticas.isEmpty())
			            	{
			            		System.out.println("No hay notas registradas. ");
			            	}
			            	else
			            	{
			            		for (Puntajes puntaje : puntajesPracticas){
			            			System.out.println(puntaje);
			            		}
			            	}
		            		break;
		            		
		            	case 3:
		            		System.out.println("Volviendo al menú principal");
		            		salida = 1;
		            		break;
		            	}
	            	}
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            case 4:
	            	System.out.println("| ---------- | SOLOCIONARIO | ---------- |\n"
	            			+ "Materias:");

	                Set<String> Materias = obtenerMateriasDesdeCarpeta(carpetaPreguntas);

	                for (String materia : Materias)
	                {
	                    System.out.println("- " + materia);
	                }
	                System.out.println("Escriba una opción una materia: ");
	                String materiaSeleccionada = entrada.next();
	            	String rutaCSV = "src/Preguntas/" + materiaSeleccionada + ".csv";
	            	archivo.leerArchivoCSV(rutaCSV);
	            	break;

	            case 5:
	            	System.out.println("Saliendo del programa...");
	            	salir = true;
	            	LimpiarPantalla.limpiarPantalla();
	            	break;

	            default:
	            	System.out.println("Ingrese una opción valida");
	        }
	    }
	    entrada.close();
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
