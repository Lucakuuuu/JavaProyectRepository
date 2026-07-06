package VentanasDeSeleccion;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Codigo.BancoPreguntas;
import Codigo.Nota;
import Codigo.Puntajes;
import VentanasDeMenus.*;

public class VentanaSeleccionPuntajes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboMaterias;

    public VentanaSeleccionPuntajes(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Seleccionar Materia para puntajes");
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
        JButton btnVerPuntajes = new JButton("Ver Puntajes");
        btnVerPuntajes.setForeground(Color.WHITE);
        btnVerPuntajes.setBackground(Color.BLACK);
        btnVerPuntajes.setBounds(189, 200, 306, 35);
        contentPane.add(btnVerPuntajes);

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(Color.BLACK);
        btnRegresar.setBounds(189, 240, 306, 35);
        contentPane.add(btnRegresar);

        // Acción para ver notas
        btnVerPuntajes.addActionListener(e -> {
            String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
            if (materiaSeleccionada != null) {
            	mostrarPuntajes(materiaSeleccionada, puntajesPracticas);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una materia.");
            }
        });

        // Acción para regresar al menú principal
        btnRegresar.addActionListener(e -> {
            new VentanaMenuPracticas(materias, bancosPorTema, registroNotas, puntajesPracticas);  // Volver a la ventana principal
            dispose();  // Cerrar la ventana actual
        });

        // Mostrar la ventana
        setVisible(true);
    }
    
    // Método para mostrar los puntajes filtrados por materia
    private void mostrarPuntajes(String materiaSeleccionada, List<Puntajes> puntajesPracticas) {
        StringBuilder puntajesTexto = new StringBuilder();
        List<Puntajes> puntajesFiltrados = new ArrayList<>();

        // Filtrar los puntajes por la materia seleccionada
        for (Puntajes puntaje : puntajesPracticas) {
            if (materiaSeleccionada.equals(puntaje.getMateria())) {
                puntajesFiltrados.add(puntaje);
            }
        }

        if (puntajesFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay puntajes registrados para " + materiaSeleccionada + ".");
        } else {
            // Crear el texto para los puntajes
            for (Puntajes puntaje : puntajesFiltrados) {
                puntajesTexto.append("---------------- o -----------------\n")
                             .append(puntaje.toString())
                             .append("\n");
            }
            // Mostrar los puntajes en un JOptionPane
            JOptionPane.showMessageDialog(this, "Puntajes para " + materiaSeleccionada + ":\n" + puntajesTexto.toString());
        }
    }
}
