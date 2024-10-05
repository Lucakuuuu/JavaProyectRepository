package ventanas;

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

public class VentanaSeleccionSolucionario extends JFrame {  // Extender de JFrame
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaSeleccionSolucionario(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Ver Solucionario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450); // Ajustar para tener espacio para los botones adicionales
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta para seleccionar materia
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSeleccionarMateria.setBounds(50, 30, 300, 30);
        contentPane.add(lblSeleccionarMateria);

        // ComboBox para seleccionar la materia
        String[] materiasArray = materias.toArray(new String[0]);
        JComboBox<String> comboMaterias = new JComboBox<>(materiasArray);
        comboMaterias.setBounds(100, 80, 200, 30);
        contentPane.add(comboMaterias);

        // Botón para ver el solucionario
        JButton btnVerSolucionario = new JButton("Ver Solucionario");  // Cambiado el texto del botón
        btnVerSolucionario.setForeground(Color.WHITE);
        btnVerSolucionario.setBackground(Color.BLACK);
        btnVerSolucionario.setBounds(100, 150, 200, 30);
        contentPane.add(btnVerSolucionario);

        // Botón para regresar al menú de prácticas
        JButton btnRegresarMenuPracticas = new JButton("Regresar al Menú Extras");
        btnRegresarMenuPracticas.setForeground(Color.WHITE);
        btnRegresarMenuPracticas.setBackground(Color.BLACK);
        btnRegresarMenuPracticas.setBounds(100, 190, 200, 30); // Añadido debajo del botón anterior
        contentPane.add(btnRegresarMenuPracticas);

        setVisible(true);

        // Acción al presionar el botón de ver solucionario
        btnVerSolucionario.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            BancoPreguntas bancoSeleccionado = bancosPorTema.get(materiaSeleccionada);
            new VentanaSolucionario(materias, bancosPorTema, registroNotas, puntajesPracticas, materiaSeleccionada, bancoSeleccionado);  // Mostrar el solucionario
            dispose(); // Cerrar esta ventana después de mostrar el solucionario
        });

        // Acción al presionar el botón de regresar al menú de prácticas
        btnRegresarMenuPracticas.addActionListener(e -> {
            new VentanaMenuPracticas(materias, bancosPorTema, registroNotas, puntajesPracticas); // Abrir el menú de prácticas
            dispose(); // Cerrar esta ventana
        });
    }
}
