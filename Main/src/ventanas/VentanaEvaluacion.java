package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEvaluacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JRadioButton[] opciones; // Arreglo para las opciones
    private ButtonGroup grupoOpciones;
    private JLabel lblNumeroPregunta;
    private JLabel lblEnunciado;
    private JButton btnSiguiente;
    private int indicePregunta;
    private Evaluacion evaluacion;
    private List<Pregunta> preguntas;
    private int puntuacion;
    private List<Nota> registroNotas;

    public VentanaEvaluacion(Evaluacion evaluacion, String nombreEstudiante, String tema, List<Nota> registroNotas) {
        this.evaluacion = evaluacion;
        this.preguntas = evaluacion.getBanco().getPreguntas();
        this.indicePregunta = 0;
        this.puntuacion = 0;
        this.registroNotas = registroNotas;

        setTitle("Evaluación de Estudiante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicialización de las etiquetas y botones
        lblNumeroPregunta = new JLabel();
        lblNumeroPregunta.setBounds(20, 20, 200, 30);
        contentPane.add(lblNumeroPregunta);

        lblEnunciado = new JLabel();
        lblEnunciado.setBounds(20, 60, 450, 30);
        contentPane.add(lblEnunciado);

        // Inicializar el grupo de opciones
        grupoOpciones = new ButtonGroup();
        opciones = new JRadioButton[4];
        
        for (int i = 0; i < 4; i++) {
            opciones[i] = new JRadioButton();
            opciones[i].setBounds(20, 100 + (i * 30), 450, 30);
            grupoOpciones.add(opciones[i]);
            contentPane.add(opciones[i]);
        }

        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(150, 300, 100, 30);
        contentPane.add(btnSiguiente);
        
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (grupoOpciones.getSelection() == null) {
                    JOptionPane.showMessageDialog(contentPane, "Por favor, selecciona una respuesta.");
                } else {
                    registrarRespuesta(indicePregunta);
                    indicePregunta++;
                    if (indicePregunta < preguntas.size()) {
                        cargarPregunta(indicePregunta);
                    } else {
                    	int maxPuntuacion = preguntas.size();
                        JOptionPane.showMessageDialog(contentPane, "Has terminado la evaluación.\nPuntuación: " + evaluacion.getPuntuacion() + "\nPuntuacion máxima: "+ maxPuntuacion);
                        Nota nuevaNota = new Nota(nombreEstudiante, tema, evaluacion.getPuntuacion(), maxPuntuacion);
                        registroNotas.add(nuevaNota);
                        dispose();
                    }
                }
            }
        });

        cargarPregunta(indicePregunta);
        setVisible(true);
    }

    private void cargarPregunta(int indice) {
        Pregunta preguntaActual = preguntas.get(indice);

        lblNumeroPregunta.setText("Pregunta " + (indice + 1));
        lblEnunciado.setText(preguntaActual.getEnunciado());

        String[] respuestas = preguntaActual.getRespuestas();
        for (int i = 0; i < 4; i++) {
            opciones[i].setText(respuestas[i]);
        }

        grupoOpciones.clearSelection();
    }

    private void registrarRespuesta(int indicePregunta) {
        Pregunta preguntaActual = preguntas.get(indicePregunta);

        String respuestaSeleccionada = null;
        for (int i = 0; i < 4; i++) {
            if (opciones[i].isSelected()) {
                respuestaSeleccionada = opciones[i].getText();
                break;
            }
        }

        if (preguntaActual.esCorrecta(respuestaSeleccionada)) {
            puntuacion++; // Aumentar la puntuación si la respuesta es correcta
        }
    }
}
