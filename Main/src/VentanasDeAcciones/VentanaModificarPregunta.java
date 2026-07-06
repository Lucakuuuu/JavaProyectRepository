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

public class VentanaModificarPregunta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxPreguntas;
    private JTextArea textAreaPregunta;
    private JButton btnModificar, btnVolver, btnConfirmar;
    private BancoPreguntas bancoSeleccionado;
    private Map<String, BancoPreguntas> bancosPorTema;
    private Set<String> materias;
    private List<Nota> registroNotas;
    private List<Puntajes> puntajesPracticas;

    public VentanaModificarPregunta(BancoPreguntas bancoSeleccionado, Set<String> materias,
                                    Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas,
                                    List<Puntajes> puntajesPracticas) {
        this.bancoSeleccionado = bancoSeleccionado;
        this.bancosPorTema = bancosPorTema;
        this.materias = materias;
        this.registroNotas = registroNotas;
        this.puntajesPracticas = puntajesPracticas;

        setTitle("Modificar Pregunta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // ComboBox para seleccionar la pregunta
        comboBoxPreguntas = new JComboBox<>();
        List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();
        for (int i = 0; i < preguntas.size(); i++) {
            comboBoxPreguntas.addItem((i + 1) + ". " + preguntas.get(i).getEnunciado());
        }
        contentPane.add(comboBoxPreguntas, BorderLayout.NORTH);

        // TextArea para mostrar y modificar el enunciado de la pregunta
        textAreaPregunta = new JTextArea();
        textAreaPregunta.setFont(new Font("Monospaced", Font.PLAIN, 14));
        contentPane.add(new JScrollPane(textAreaPregunta), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Botón para modificar la pregunta (solo habilita el área de texto)
        btnModificar = new JButton("Modificar esta Pregunta");
        panelBotones.add(btnModificar);
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaPregunta.setEditable(true);  // Habilitar la edición del TextArea
            }
        });

        // Botón para confirmar la modificación
        btnConfirmar = new JButton("Confirmar Modificación");
        panelBotones.add(btnConfirmar);
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarModificacion();
            }
        });

        // Botón para volver al menú
        btnVolver = new JButton("Volver");
        panelBotones.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAlMenu();
            }
        });

        contentPane.add(panelBotones, BorderLayout.SOUTH);

        // Listener para cargar la pregunta seleccionada en el área de texto
        comboBoxPreguntas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarPreguntaSeleccionada();
            }
        });

        setVisible(true);
        cargarPreguntaSeleccionada();  // Cargar la primera pregunta por defecto
    }

    // Método para cargar la pregunta seleccionada en el TextArea
    private void cargarPreguntaSeleccionada() {
        int indicePregunta = comboBoxPreguntas.getSelectedIndex();
        List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();

        if (indicePregunta >= 0 && indicePregunta < preguntas.size()) {
            Pregunta preguntaSeleccionada = preguntas.get(indicePregunta);
            textAreaPregunta.setText(preguntaSeleccionada.getEnunciado());
            textAreaPregunta.setEditable(false);  // Desactivar edición inicialmente
        }
    }

    // Método para confirmar la modificación de la pregunta seleccionada
    private void confirmarModificacion() {
        int indicePregunta = comboBoxPreguntas.getSelectedIndex();
        List<Pregunta> preguntas = bancoSeleccionado.getPreguntas();

        if (indicePregunta >= 0 && indicePregunta < preguntas.size()) {
            Pregunta preguntaAModificar = preguntas.get(indicePregunta);

            // Actualizar el enunciado de la pregunta con el texto del TextArea
            String PreguntaModificada = textAreaPregunta.getText();

            // Guardar los cambios en el archivo CSV
            new VentanaModificarRespuestas(preguntaAModificar, PreguntaModificada, bancoSeleccionado, bancosPorTema);
        } else {
            JOptionPane.showMessageDialog(this, "Índice de pregunta no válido.");
        }
    }

    // Método para volver al menú principal
    private void volverAlMenu() {
        new VentanaMenuExtras(materias, bancosPorTema, registroNotas, puntajesPracticas);
        dispose();
    }
}
