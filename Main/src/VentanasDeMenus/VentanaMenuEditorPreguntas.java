package VentanasDeMenus;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import Codigo.*;

import VentanasDeSeleccion.*;
import VentanasDeMenus.*;
import VentanasDeAcciones.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class VentanaMenuEditorPreguntas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaMenuEditorPreguntas(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
		setTitle("Menú de Editor de Preguntas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Etiqueta de bienvenida
		JLabel lblPracticas = new JLabel("Seleccione una Opción");
		lblPracticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPracticas.setBounds(189, 50, 306, 44);
		contentPane.add(lblPracticas);
		
		// Botón "Realizar una práctica"
		JButton btnEliminarPregunta = new JButton("Eliminar una pregunta");
		btnEliminarPregunta.setForeground(new Color(255, 255, 255));
		btnEliminarPregunta.setBackground(Color.BLACK);
		btnEliminarPregunta.setBounds(189, 120, 306, 30);
		contentPane.add(btnEliminarPregunta);
		
		// Botón "Ver puntajes obtenidos"
		JButton btnModificarPregunta = new JButton("Modificar una Pregunta");
		btnModificarPregunta.setForeground(new Color(255, 255, 255));
		btnModificarPregunta.setBackground(Color.BLACK);
		btnModificarPregunta.setBounds(189, 160, 306, 30);
		contentPane.add(btnModificarPregunta);
		
		// Botón "Volver al Menú Principal"
		JButton btnVolver = new JButton("Volver al Menú Extras");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setBounds(189, 200, 306, 30);
		contentPane.add(btnVolver);
		
		setVisible(true);

		// Acción para realizar una práctica
		btnEliminarPregunta.addActionListener(e -> {
				new VentanaSeleccionELiminarPregunta(materias, bancosPorTema, registroNotas, puntajesPracticas);
				dispose();
			}
		);
		
		btnModificarPregunta.addActionListener(e -> {
				new VentanaSeleccionModificarPregunta(materias, bancosPorTema, registroNotas, puntajesPracticas);
				dispose();
			}
		);
		
		// Acción para regresar al menú principal
		btnVolver.addActionListener(e -> {
            new VentanaMenuExtras(materias, bancosPorTema, registroNotas, puntajesPracticas);  // Volver al menú Extras
            dispose();  // Cerrar la ventana actual
        });
	}
}
