package ventanas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuPrincipal() {
		setTitle("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Botón "Registro de notas"
		JButton btnRegistroDeNotas = new JButton("Registro de notas");
		btnRegistroDeNotas.setForeground(Color.WHITE);
		btnRegistroDeNotas.setBackground(Color.BLACK);
		btnRegistroDeNotas.setBounds(189, 190, 306, 30);
		contentPane.add(btnRegistroDeNotas);
		
		// Botón "Realizar evaluación"
		JButton btnRealizarEvaluacion = new JButton("Realizar evaluación");
		btnRealizarEvaluacion.setForeground(Color.WHITE);
		btnRealizarEvaluacion.setBackground(Color.BLACK);
		btnRealizarEvaluacion.setBounds(189, 149, 306, 30);
		contentPane.add(btnRealizarEvaluacion);
		
		// Botón "Prácticas"
		JButton btnPracticas = new JButton("Prácticas");
		btnPracticas.setForeground(Color.WHITE);
		btnPracticas.setBackground(Color.BLACK);
		btnPracticas.setBounds(189, 231, 306, 30);
		contentPane.add(btnPracticas);
		
		// Etiqueta de bienvenida
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setToolTipText("Elije una opción");
		lblNewLabel.setBounds(130, 80, 420, 44);
		contentPane.add(lblNewLabel);
		
		// Botón "Cerrar aplicación"
		JButton btnCerrar = new JButton("Cerrar aplicación");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(Color.BLACK);
		btnCerrar.setBounds(189, 272, 306, 30);
		contentPane.add(btnCerrar);

		// Acción para iniciar evaluación
		btnRealizarEvaluacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaSeleccionEvaluacion(); // Abre la ventana de selección de evaluación
			}
		});
		
		// Acción para ver registro de notas
		btnRegistroDeNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistroNotas(); // Abre la ventana de registro de notas
			}
		});
		
		// Acción para ir a "Prácticas"
		btnPracticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaPracticas(); // Abre la ventana de prácticas
			}
		});
	}
}
