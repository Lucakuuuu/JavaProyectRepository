package Programa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Codigo.*;
import ventanas.VentanaPrincipal;

public class AppLauncher {
    public static void main(String[] args) {
    	
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
	    	//Menus.menuPrincipal();
	    	new VentanaPrincipal(materias, bancosPorTema, registroNotas);
	    	salir = true;
	    }
    }
}
