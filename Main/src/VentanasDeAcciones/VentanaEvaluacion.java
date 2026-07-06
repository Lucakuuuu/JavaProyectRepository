package VentanasDeAcciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import VentanasDeMenus.VentanaMenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private List<Puntajes> puntajesPracticas;
    private Set<String> materias;
    private Map<String, BancoPreguntas> bancosPorTema;
    private List<Nota> registroNotas;

    public VentanaEvaluacion(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Puntajes> puntajesPracticas, Evaluacion evaluacion, String nombreEstudiante, String tema, List<Nota> registroNotas) {
    	this.evaluacion = evaluacion;
        this.preguntas = evaluacion.getBanco().getPreguntas();
        this.indicePregunta = 0;
        this.puntajesPracticas = puntajesPracticas;
        this.materias = materias; // Guardar materias
        this.bancosPorTema = bancosPorTema; // Guardar bancos de preguntas
        this.registroNotas = registroNotas; // Guardar registro de notas

        setTitle("Evaluación de Estudiante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);
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
        btnSiguiente.setBounds(189, 300, 306, 30);
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
                        dispose(); // Cerrar la ventana de prácticas antes de abrir el menú principal
                        
                        // Aquí abrimos la ventana de menú principal después de que se haya cerrado la evaluación
                        new VentanaMenuPrincipal(materias, bancosPorTema, registroNotas, puntajesPracticas);
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

        // Crear un arreglo de letras para las opciones
        String[] letrasOpciones = {"A", "B", "C", "D"};
        String respuestaSeleccionada = null;

        // Buscar cuál opción fue seleccionada y asignar la letra correspondiente
        for (int i = 0; i < 4; i++) {
            if (opciones[i].isSelected()) {
                respuestaSeleccionada = letrasOpciones[i]; // Asignar la letra (A, B, C, o D)
                break;
            }
        }
        if (preguntaActual.esCorrecta(respuestaSeleccionada)) {
            evaluacion.incrementarPuntuacion(); // Aumentar la puntuación si la respuesta es correcta
        }
    }

}
