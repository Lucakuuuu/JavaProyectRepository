package ventanas;

import javax.swing.*;
import tarea.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaRegistroNotas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaRegistroNotas() {
        // Configuración de la ventana
        setTitle("Ver Registro de Notas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta para seleccionar la materia
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSeleccionarMateria.setBounds(50, 30, 300, 30);
        contentPane.add(lblSeleccionarMateria);

        // Lista de materias
        String[] materias = { "Matemáticas", "Historia", "Ciencias", "Literatura" };
        JComboBox<String> comboMaterias = new JComboBox<>(materias);
        comboMaterias.setBounds(100, 80, 200, 30);
        contentPane.add(comboMaterias);

        // Botón para ver el registro de notas
        JButton btnVerNotas = new JButton("Ver Notas");
        btnVerNotas.setForeground(Color.WHITE);
        btnVerNotas.setBackground(Color.BLACK);
        btnVerNotas.setBounds(100, 220, 200, 30);
        contentPane.add(btnVerNotas);

        setVisible(true);

        // Acción para ver las notas
        btnVerNotas.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            
            // Datos de ejemplo para cada materia
            Object[][] data = {};
            if ("Matemáticas".equals(materiaSeleccionada)) {
                data = new Object[][] {
                    { "Juan", "85" },
                    { "Ana", "90" },
                    { "Luis", "78" }
                };
            } else if ("Historia".equals(materiaSeleccionada)) {
                data = new Object[][] {
                    { "Carlos", "88" },
                    { "María", "92" },
                    { "Sofía", "79" }
                };
            } else if ("Ciencias".equals(materiaSeleccionada)) {
                data = new Object[][] {
                    { "David", "80" },
                    { "Laura", "85" },
                    { "Pedro", "70" }
                };
            } else if ("Literatura".equals(materiaSeleccionada)) {
                data = new Object[][] {
                    { "Andrea", "95" },
                    { "Mateo", "87" },
                    { "Valeria", "82" }
                };
            }

            // Mostrar tabla con los datos correspondientes
            String[] columnNames = { "Estudiante", "Nota" };
            JTable tableRegistroNotas = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(tableRegistroNotas);
            scrollPane.setBounds(50, 120, 300, 100);
            contentPane.add(scrollPane);

            // Refrescar la interfaz para mostrar la tabla correctamente
            contentPane.revalidate();
            contentPane.repaint();
        });
    }

    public static void main(String[] args) {
        new VentanaRegistroNotas();
    }
}
