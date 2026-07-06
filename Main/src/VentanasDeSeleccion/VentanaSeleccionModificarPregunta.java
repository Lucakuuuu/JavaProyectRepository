package VentanasDeSeleccion;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import Codigo.*;
import VentanasDeAcciones.VentanaModificarPregunta;
import VentanasDeMenus.VentanaMenuEditorPreguntas;

public class VentanaSeleccionModificarPregunta extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

	public VentanaSeleccionModificarPregunta(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema,
			List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
		
		setTitle("Modificar una Pregunta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblSeleccionarMateria.setToolTipText("Elije una opción");
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSeleccionarMateria.setBounds(189, 80, 306, 44);
        contentPane.add(lblSeleccionarMateria);

        // ComboBox para seleccionar la materia
        String[] materiasArray = materias.toArray(new String[0]);
        JComboBox<String> comboMaterias = new JComboBox<>(materiasArray);
        comboMaterias.setBounds(189, 140, 306, 35);
        contentPane.add(comboMaterias);
        
     // Botón para iniciar la práctica
        JButton btnModificarPregunta = new JButton("Modificar una pregunta");
        btnModificarPregunta.setForeground(Color.WHITE);
        btnModificarPregunta.setBackground(Color.BLACK);
        btnModificarPregunta.setBounds(189, 200, 306, 35);
        contentPane.add(btnModificarPregunta);
        
        // Botón para regresar al menú de prácticas
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(Color.BLACK);
        btnRegresar.setBounds(189, 240, 306, 35); // Añadido debajo del botón anterior
        contentPane.add(btnRegresar);

        setVisible(true);
        
        btnModificarPregunta.addActionListener(e -> {
        	String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            BancoPreguntas bancoSeleccionado = bancosPorTema.get(materiaSeleccionada);
        	new VentanaModificarPregunta(bancoSeleccionado, materias, bancosPorTema, registroNotas, puntajesPracticas);
        	dispose();
        });
        
     // Acción al presionar el botón de regresar al menú de prácticas
        btnRegresar.addActionListener(e -> {
            new VentanaMenuEditorPreguntas(materias, bancosPorTema, registroNotas, puntajesPracticas);
            dispose(); // Cerrar esta ventana
        });
	}
}
