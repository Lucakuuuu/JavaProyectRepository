package Programa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import Codigo.*;
import ventanas.VentanaMenuPrincipal;

public class AppLauncher {
    public static void main(String[] args) {
    	
		Map<String, BancoPreguntas> bancosPorTema = new HashMap<>();
		List<Nota> registroNotas = new ArrayList<>();
		List<Puntajes> puntajesPracticas = new ArrayList<>();
	    boolean salir = false;

	    Set<String> materias = ObtenerDatos.obtenerMateriasDesdeCarpeta("src/Preguntas/");
	    bancosPorTema = ObtenerDatos.cargarMaterias("src/Preguntas/", materias, bancosPorTema);
	    
	    while(!salir)
	    {
	    	//Menus.menuPrincipal();
	    	new VentanaMenuPrincipal(materias, bancosPorTema, registroNotas, puntajesPracticas);
	    	salir = true;
	    }
    }
}
