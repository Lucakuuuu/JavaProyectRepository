package VentanasDeSeleccion;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import VentanasDeAcciones.*;
import VentanasDeMenus.VentanaMenuEditorPreguntas;

public class VentanaSeleccionAgregarPregunta extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;

	public VentanaSeleccionAgregarPregunta(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema,
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
        JButton btnAgregarPregunta = new JButton("Agregar una pregunta");
        btnAgregarPregunta.setForeground(Color.WHITE);
        btnAgregarPregunta.setBackground(Color.BLACK);
        btnAgregarPregunta.setBounds(189, 200, 306, 35);
        contentPane.add(btnAgregarPregunta);
        
        // Botón para regresar al menú de prácticas
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(Color.BLACK);
        btnRegresar.setBounds(189, 240, 306, 35); // Añadido debajo del botón anterior
        contentPane.add(btnRegresar);

        setVisible(true);
        
        btnAgregarPregunta.addActionListener(e -> {
        	String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            BancoPreguntas bancoSeleccionado = bancosPorTema.get(materiaSeleccionada);
        	new VentanaAgregarPregunta(bancoSeleccionado, materias, bancosPorTema, registroNotas, puntajesPracticas);
        	dispose();
        });
        
     // Acción al presionar el botón de regresar al menú de prácticas
        btnRegresar.addActionListener(e -> {
            new VentanaMenuEditorPreguntas(materias, bancosPorTema, registroNotas, puntajesPracticas);
            dispose(); // Cerrar esta ventana
        });
	}
}
