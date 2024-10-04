package ventanas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Codigo.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPracticas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPracticas() {
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
		lblPracticas.setBounds(130, 50, 420, 44);
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
		btnVerPuntajes.setBounds(189, 180, 306, 30);
		contentPane.add(btnVerPuntajes);
		
		// Botón "Volver al Menú Principal"
		JButton btnVolver = new JButton("Volver al Menú Principal");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setBounds(189, 240, 306, 30);
		contentPane.add(btnVolver);
		
		setVisible(true);

		// Acción para realizar una práctica
		btnRealizarPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaSeleccionMaterias(); // Abrir nueva ventana para seleccionar materia
			}
		});

		// Acción para ver puntajes obtenidos
		btnVerPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaPuntajes(); // Abrir nueva ventana para ver los puntajes
			}
		});
		
		// Acción para volver al menú principal
		btnVolver.addActionListener(e -> {
			setVisible(false);
			new VentanaPrincipal(null, null); // Vuelve a mostrar la ventana principal
		});
	}
}