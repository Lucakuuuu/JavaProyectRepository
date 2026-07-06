package VentanasDeAcciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import Codigo.*;
import VentanasDeMenus.VentanaMenuExtras;

public class VentanaEliminarPregunta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxPreguntas;
    private JButton btnEliminar, btnVolver;
    private BancoPreguntas bancoSeleccionado;
    private Map<String, BancoPreguntas> bancosPorTema;
    private Set<String> materias;
    private List<Nota> registroNotas;
    private List<Puntajes> puntajesPracticas;

    public VentanaEliminarPregunta(BancoPreguntas bancoSeleccionado, Set<String> materias,
                                   Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas,
                                   List<Puntajes> puntajesPracticas) {
        this.bancoSeleccionado = bancoSeleccionado;
        this.bancosPorTema = bancosPorTema;
        this.materias = materias;
        this.registroNotas = registroNotas;
        this.puntajesPracticas = puntajesPracticas;

        setTitle("Eliminar Pregunta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Crear el comboBox para seleccionar la pregunta
        comboBoxPreguntas = new JComboBox<>();
        List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();
        for (int i = 0; i < preguntas.size(); i++) {
            comboBoxPreguntas.addItem((i + 1) + ". " + preguntas.get(i).getEnunciado());
        }
        contentPane.add(comboBoxPreguntas, BorderLayout.NORTH);

        // Crear botón de eliminar más pequeño
        btnEliminar = new JButton("Eliminar Pregunta");
        btnEliminar.setPreferredSize(new Dimension(90, 30));  // Tamaño personalizado
        contentPane.add(btnEliminar, BorderLayout.CENTER);

        // Añadir listener al botón de eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPreguntaSeleccionada();
            }
        });

        // Crear botón para volver al menú
        btnVolver = new JButton("Volver al Menú Principal");
        contentPane.add(btnVolver, BorderLayout.SOUTH);

        // Añadir listener al botón de volver
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAlMenu();
            }
        });

        setVisible(true);
    }

    // Método para eliminar la pregunta seleccionada
    private void eliminarPreguntaSeleccionada() {
        int indicePregunta = comboBoxPreguntas.getSelectedIndex();
        List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();

        if (indicePregunta >= 0 && indicePregunta < preguntas.size()) {
            Pregunta preguntaAEliminar = preguntas.get(indicePregunta);

            // Lógica para eliminar la pregunta
            bancosPorTema = ObtenerDatos.eliminarPregunta(bancoSeleccionado.getTema(), preguntaAEliminar, bancosPorTema);
            
            // Actualizar comboBox
            comboBoxPreguntas.removeItemAt(indicePregunta);
            JOptionPane.showMessageDialog(this, "Pregunta eliminada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Índice de pregunta inválido.");
        }
    }

    // Método para volver al menú principal
    private void volverAlMenu() {
        // Crear una nueva ventana de menú y cerrar esta ventana
        new VentanaMenuExtras(materias, bancosPorTema, registroNotas, puntajesPracticas);
        dispose();
    }
}
