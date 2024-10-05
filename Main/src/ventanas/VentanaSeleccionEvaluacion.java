package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VentanaSeleccionEvaluacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombreEstudiante;
    Scanner entrada = new Scanner(System.in);

    public VentanaSeleccionEvaluacion(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Iniciar Evaluación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        String[] materiasArray = materias.toArray(new String[0]);
        JComboBox<String> comboMaterias = new JComboBox<>(materiasArray);
        comboMaterias.setBounds(100, 80, 200, 30);
        contentPane.add(comboMaterias);

        // Campo para ingresar el nombre del estudiante
        JLabel lblNombreEstudiante = new JLabel("Nombre del Estudiante");
        lblNombreEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNombreEstudiante.setBounds(50, 130, 300, 30);
        contentPane.add(lblNombreEstudiante);

        txtNombreEstudiante = new JTextField();
        txtNombreEstudiante.setBounds(100, 170, 200, 30);
        contentPane.add(txtNombreEstudiante);
        txtNombreEstudiante.setColumns(10);

        // Botón para iniciar la evaluación
        JButton btnIniciarEvaluacion = new JButton("Iniciar Evaluación");
        btnIniciarEvaluacion.setForeground(Color.WHITE);
        btnIniciarEvaluacion.setBackground(Color.BLACK);
        btnIniciarEvaluacion.setBounds(100, 220, 200, 30);
        contentPane.add(btnIniciarEvaluacion);

        setVisible(true);

        // Acción para iniciar la evaluación
        btnIniciarEvaluacion.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            BancoPreguntas bancoSeleccionado = bancosPorTema.get(materiaSeleccionada);
            String nombreEstudiante = txtNombreEstudiante.getText();
            if (nombreEstudiante.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del estudiante.");
            } else {
            	Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
                JOptionPane.showMessageDialog(this, "Iniciando evaluación de " + materiaSeleccionada + " para " + nombreEstudiante);
                new VentanaEvaluacion(evaluacion, nombreEstudiante, materiaSeleccionada, registroNotas);
            }
        });
    }
}
