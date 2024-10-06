package VentanasDeSeleccion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import Codigo.BancoPreguntas;
import Codigo.Nota;
import Codigo.Puntajes;
import VentanasDeAcciones.VentanaRegistroNotas;
import VentanasDeMenus.VentanaMenuPrincipal;

public class VentanaSeleccionRegistroNotas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboMaterias;

    public VentanaSeleccionRegistroNotas(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Seleccionar Materia para Ver Notas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450); // Ajuste del tamaño para acomodar el nuevo botón
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta de selección de materia
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblSeleccionarMateria.setToolTipText("Elije una opción");
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSeleccionarMateria.setBounds(189, 80, 306, 44);
        contentPane.add(lblSeleccionarMateria);

        // Lista de materias
        String[] materiasArray = materias.toArray(new String[0]);
        comboMaterias = new JComboBox<>(materiasArray);
        comboMaterias.setBounds(189, 140, 306, 35);
        contentPane.add(comboMaterias);

        // Botón para ver notas
        JButton btnVerNotas = new JButton("Ver Notas");
        btnVerNotas.setForeground(Color.WHITE);
        btnVerNotas.setBackground(Color.BLACK);
        btnVerNotas.setBounds(189, 200, 306, 35);
        contentPane.add(btnVerNotas);

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(Color.BLACK);
        btnRegresar.setBounds(189, 240, 306, 35);
        contentPane.add(btnRegresar);

        // Acción para ver notas
        btnVerNotas.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            if (materiaSeleccionada != null) {
                mostrarNotas(materiaSeleccionada, registroNotas);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una materia.");
            }
        });

        // Acción para regresar al menú principal
        btnRegresar.addActionListener(e -> {
            new VentanaMenuPrincipal(materias, bancosPorTema, registroNotas, puntajesPracticas);  // Volver a la ventana principal
            dispose();  // Cerrar la ventana actual
        });

        // Mostrar la ventana
        setVisible(true);
    }

    private void mostrarNotas(String materiaSeleccionada, List<Nota> registroNotas) {
        StringBuilder notasTexto = new StringBuilder();
        List<Nota> notasFiltradas = new ArrayList<>();
        
        // Filtramos las notas para la materia seleccionada
        for (Nota nota : registroNotas) {
            if (materiaSeleccionada.equals(nota.getTema())) {
                notasFiltradas.add(nota);
            }
        }

        if (notasFiltradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay notas registradas para " + materiaSeleccionada + ".");
        } else {
            // Crear el texto para las notas
            for (Nota nota : notasFiltradas) {
                notasTexto.append("---------------- o -----------------\n")
                          .append(nota.toString())
                          .append("\n");
            }
            // Mostrar las notas en un JOptionPane
            JOptionPane.showMessageDialog(this, "Notas para " + materiaSeleccionada + ":\n" + notasTexto.toString());
            
            // Opcionalmente, puedes abrir una ventana con el registro completo
            // new VentanaRegistroNotas(registroNotas);
        }
    }
}
