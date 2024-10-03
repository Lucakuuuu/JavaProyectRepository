package ventanas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class VentanaPuntajes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaPuntajes() {
		setTitle("Puntajes Obtenidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPuntajes = new JLabel("Puntajes Obtenidos");
		lblPuntajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntajes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntajes.setBounds(50, 30, 300, 30);
		contentPane.add(lblPuntajes);
		
		// Tabla con los puntajes obtenidos (ejemplo)
		String[] columnNames = { "Materia", "Puntaje", "Máx. Puntaje" };
		Object[][] data = {
			{ "Matemáticas", "85", "100" },
			{ "Historia", "90", "100" },
			{ "Ciencias", "78", "100" }
		};
		JTable tablePuntajes = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(tablePuntajes);
		scrollPane.setBounds(50, 80, 300, 100);
		contentPane.add(scrollPane);

		setVisible(true);
	}
}
