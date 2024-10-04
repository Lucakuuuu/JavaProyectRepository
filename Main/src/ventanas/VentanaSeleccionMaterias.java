package ventanas;

import java.awt.*;
import tarea.*;
import javax.swing.*;
import javax.swing.border.*;

class VentanaSeleccionMaterias extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaSeleccionMaterias() {
		setTitle("Seleccionar Materia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
		lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeleccionarMateria.setBounds(50, 30, 300, 30);
		contentPane.add(lblSeleccionarMateria);
		
		// Lista de materias (puedes añadir las materias que desees)
		String[] materias = { "Matemáticas", "Historia", "Ciencias", "Literatura" };
		JComboBox<String> comboMaterias = new JComboBox<>(materias);
		comboMaterias.setBounds(100, 80, 200, 30);
		contentPane.add(comboMaterias);
		
		JButton btnIniciarPractica = new JButton("Iniciar Práctica");
		btnIniciarPractica.setForeground(Color.WHITE);
		btnIniciarPractica.setBackground(Color.BLACK);
		btnIniciarPractica.setBounds(100, 140, 200, 30);
		contentPane.add(btnIniciarPractica);

		setVisible(true);

		// Acción para iniciar la práctica
		btnIniciarPractica.addActionListener(e -> {
			String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
			JOptionPane.showMessageDialog(this, "Iniciando práctica de " + materiaSeleccionada);
			// Aquí puedes abrir otra ventana con las preguntas correspondientes
		});
	}
}