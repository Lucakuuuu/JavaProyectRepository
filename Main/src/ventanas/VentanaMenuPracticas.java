package ventanas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Codigo.*;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;

public class VentanaMenuPracticas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param puntajesPracticas 
	 * @param bancosPorTema 
	 * @param materias 
	 * @param registroNotas 
	 */
	public VentanaMenuPracticas(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
		setTitle("Menú de Extras");
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
		JButton btnRealizarPractica = new JButton("Realizar una práctica");
		btnRealizarPractica.setForeground(new Color(255, 255, 255));
		btnRealizarPractica.setBackground(Color.BLACK);
		btnRealizarPractica.setBounds(189, 120, 306, 30);
		contentPane.add(btnRealizarPractica);
		
		// Botón "Ver puntajes obtenidos"
		JButton btnVerPuntajes = new JButton("Ver puntajes obtenidos");
		btnVerPuntajes.setForeground(new Color(255, 255, 255));
		btnVerPuntajes.setBackground(Color.BLACK);
		btnVerPuntajes.setBounds(189, 160, 306, 30);
		contentPane.add(btnVerPuntajes);
		
		// Botón "Volver al Menú Principal"
		JButton btnVolver = new JButton("Volver al Menú Principal");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setBounds(189, 200, 306, 30);
		contentPane.add(btnVolver);
		
		setVisible(true);

		// Acción para realizar una práctica
		btnRealizarPractica.addActionListener(e -> {
				new VentanaSeleccionPracticas(materias, bancosPorTema, registroNotas, puntajesPracticas);
				dispose();
			}
		);

		// Acción para ver puntajes obtenidos
		btnVerPuntajes.addActionListener(e -> {
				new VentanaPuntajes(materias, bancosPorTema, registroNotas, puntajesPracticas);
				dispose();
			}
		);
		
		// Acción para volver al menú principal
		btnVolver.addActionListener(e -> {
				new VentanaMenuPrincipal(materias, bancosPorTema, registroNotas, puntajesPracticas);
				dispose();
			}
		);
	}
}