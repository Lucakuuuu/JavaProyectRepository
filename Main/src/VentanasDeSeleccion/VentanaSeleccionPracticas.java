package VentanasDeSeleccion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import VentanasDeAcciones.VentanaPracticas;
import VentanasDeMenus.VentanaMenuPracticas;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class VentanaSeleccionPracticas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaSeleccionPracticas(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Iniciar Práctica");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450); // Ajustar para tener espacio para los botones adicionales
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta para seleccionar materia
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
        JButton btnIniciarPractica = new JButton("Iniciar Práctica");
        btnIniciarPractica.setForeground(Color.WHITE);
        btnIniciarPractica.setBackground(Color.BLACK);
        btnIniciarPractica.setBounds(189, 200, 306, 35);
        contentPane.add(btnIniciarPractica);

        // Botón para regresar al menú de prácticas
        JButton btnRegresarMenuPracticas = new JButton("Regresar al Menú de Prácticas");
        btnRegresarMenuPracticas.setForeground(Color.WHITE);
        btnRegresarMenuPracticas.setBackground(Color.BLACK);
        btnRegresarMenuPracticas.setBounds(189, 240, 306, 35); 
        contentPane.add(btnRegresarMenuPracticas);

        setVisible(true);

        // Acción al presionar el botón de iniciar práctica
        btnIniciarPractica.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            BancoPreguntas bancoSeleccionado = bancosPorTema.get(materiaSeleccionada);
            Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
            JOptionPane.showMessageDialog(this, "Iniciando Práctica de " + materiaSeleccionada);
            new VentanaPracticas(materias, bancosPorTema, registroNotas, evaluacion, materiaSeleccionada, puntajesPracticas);
            dispose(); // Cerrar esta ventana después de iniciar la práctica
        });

        // Acción al presionar el botón de regresar al menú de prácticas
        btnRegresarMenuPracticas.addActionListener(e -> {
            new VentanaMenuPracticas(materias, bancosPorTema, registroNotas, puntajesPracticas); // Abrir el menú de prácticas
            dispose(); // Cerrar esta ventana
        });
    }
}
