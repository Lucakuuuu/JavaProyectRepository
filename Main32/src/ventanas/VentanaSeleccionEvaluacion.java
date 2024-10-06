package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VentanaSeleccionEvaluacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombreEstudiante;

    public VentanaSeleccionEvaluacion(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Iniciar Evaluación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);

        // Panel principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar los elementos
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0); // Margen de 40 píxeles entre los componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Título
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblSeleccionarMateria.setToolTipText("Elije una opción");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // El título ocupa dos columnas
        contentPane.add(lblSeleccionarMateria, gbc);

        // Lista de materias
        String[] materiasArray = materias.toArray(new String[0]);
        JComboBox<String> comboMaterias = new JComboBox<>(materiasArray);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPane.add(comboMaterias, gbc);

        // Campo para ingresar el nombre del estudiante
        JLabel lblNombreEstudiante = new JLabel("Nombre del Estudiante");
        lblNombreEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPane.add(lblNombreEstudiante, gbc);

        txtNombreEstudiante = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPane.add(txtNombreEstudiante, gbc);

        // Botón para iniciar la evaluación
        JButton btnIniciarEvaluacion = new JButton("Iniciar Evaluación");
        btnIniciarEvaluacion.setForeground(Color.WHITE);
        btnIniciarEvaluacion.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        contentPane.add(btnIniciarEvaluacion, gbc);

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        contentPane.add(btnRegresar, gbc);

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
                new VentanaEvaluacion(materias, bancosPorTema, puntajesPracticas, evaluacion, nombreEstudiante, materiaSeleccionada, registroNotas);
                dispose(); // Cerrar la ventana actual al iniciar la evaluación
            }
        });

        // Acción para regresar al menú principal
        btnRegresar.addActionListener(e -> {
            new VentanaMenuPrincipal(materias, bancosPorTema, registroNotas, puntajesPracticas);
            dispose(); // Cerrar la ventana actual
        });
    }
}
