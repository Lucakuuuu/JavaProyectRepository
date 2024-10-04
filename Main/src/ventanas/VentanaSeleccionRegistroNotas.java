package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Set;

import Codigo.Nota;

public class VentanaSeleccionRegistroNotas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboMaterias;

    public VentanaSeleccionRegistroNotas(Set<String> materias, List<Nota> registroNotas) {
        setTitle("Seleccionar Materia para Ver Notas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta de selección de materia
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSeleccionarMateria.setBounds(50, 30, 300, 30);
        contentPane.add(lblSeleccionarMateria);

        // Lista de materias
        String[] materiasArray = materias.toArray(new String[0]);
        comboMaterias = new JComboBox<>(materiasArray);
        comboMaterias.setBounds(100, 80, 200, 30);
        contentPane.add(comboMaterias);

        // Botón para ver notas
        JButton btnVerNotas = new JButton("Ver Notas");
        btnVerNotas.setForeground(Color.WHITE);
        btnVerNotas.setBackground(Color.BLACK);
        btnVerNotas.setBounds(100, 130, 200, 30);
        contentPane.add(btnVerNotas);

        // Acción para ver notas
        btnVerNotas.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            if (materiaSeleccionada != null) {
                mostrarNotas(materiaSeleccionada, registroNotas);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una materia.");
            }
        });

        // Mostrar la ventana
        setVisible(true);
    }

    private void mostrarNotas(String materiaSeleccionada, List<Nota> registroNotas) {
        StringBuilder notasTexto = new StringBuilder();
        boolean hayNotas = false;

        // Si hay notas, mostrar en un cuadro de diálogo
        if (hayNotas) {
            JOptionPane.showMessageDialog(this, "Notas para " + materiaSeleccionada + ":\n" + notasTexto.toString());
            new VentanaRegistroNotas(registroNotas);
        } else {
            JOptionPane.showMessageDialog(this, "No hay notas registradas para " + materiaSeleccionada + ".");
        }
    }
}
