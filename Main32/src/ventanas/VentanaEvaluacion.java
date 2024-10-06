package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
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
    private Evaluacion NuevaEvaluacion;
    private List<Pregunta> preguntas;
    private int NuevaPuntuacion;
    private List<Puntajes> AUXPuntajesPracticas;
    private Set<String> AUXmaterias;
    private Map<String, BancoPreguntas> AUXbancosPorTema;
    private List<Nota> NuevoRegistroNotas;

    public VentanaEvaluacion(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Puntajes> puntajesPracticas, Evaluacion evaluacion, String nombreEstudiante, String tema, List<Nota> registroNotas) {
    	this.NuevaEvaluacion = evaluacion;
        this.preguntas = NuevaEvaluacion.getBanco().getPreguntas();
        this.indicePregunta = 0;
        this.NuevaPuntuacion = 0;
        this.AUXPuntajesPracticas = puntajesPracticas;
        this.AUXmaterias = materias; // Guardar materias
        this.AUXbancosPorTema = bancosPorTema; // Guardar bancos de preguntas
        this.NuevoRegistroNotas = registroNotas; // Guardar registro de notas

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
                        JOptionPane.showMessageDialog(contentPane, "Has terminado la evaluación.\nPuntuación: " + NuevaPuntuacion + "\nPuntuacion máxima: "+ maxPuntuacion);
                        Nota nuevaNota = new Nota(nombreEstudiante, tema, NuevaPuntuacion, maxPuntuacion);
                        NuevoRegistroNotas.add(nuevaNota);
                        dispose(); // Cerrar la ventana de prácticas antes de abrir el menú principal
                        
                        // Aquí abrimos la ventana de menú principal después de que se haya cerrado la evaluación
                        new VentanaMenuPrincipal(AUXmaterias, AUXbancosPorTema, NuevoRegistroNotas, AUXPuntajesPracticas);
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
        	NuevaPuntuacion++; // Aumentar la puntuación si la respuesta es correcta
        }
    }
}
