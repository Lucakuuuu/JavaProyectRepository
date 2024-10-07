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

public class VentanaAgregarPregunta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaPregunta;
    private JTextArea textAreaRespuestas;
    private JTextField textFieldRespuestaCorrecta;
    private JButton btnAgregar, btnVolver;
    private BancoPreguntas bancoSeleccionado;
    private Map<String, BancoPreguntas> bancosPorTema;
    private Set<String> materias;
    private List<Nota> registroNotas;
    private List<Puntajes> puntajesPracticas;

    public VentanaAgregarPregunta(BancoPreguntas bancoSeleccionado, Set<String> materias,
                                  Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas,
                                  List<Puntajes> puntajesPracticas) {
        this.bancoSeleccionado = bancoSeleccionado;
        this.bancosPorTema = bancosPorTema;
        this.materias = materias;
        this.registroNotas = registroNotas;
        this.puntajesPracticas = puntajesPracticas;

        setTitle("Agregar Nueva Pregunta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel central con las áreas de texto para la pregunta y las respuestas
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(3, 1));

        // TextArea para escribir el enunciado de la pregunta
        textAreaPregunta = new JTextArea();
        textAreaPregunta.setBorder(BorderFactory.createTitledBorder("Enunciado de la Pregunta"));
        textAreaPregunta.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panelCentro.add(new JScrollPane(textAreaPregunta));

        // TextArea para escribir las respuestas (una por línea)
        textAreaRespuestas = new JTextArea();
        textAreaRespuestas.setBorder(BorderFactory.createTitledBorder("Respuestas (una por línea)"));
        textAreaRespuestas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panelCentro.add(new JScrollPane(textAreaRespuestas));

        // TextField para la respuesta correcta (número de la respuesta correcta)
        textFieldRespuestaCorrecta = new JTextField();
        textFieldRespuestaCorrecta.setBorder(BorderFactory.createTitledBorder("Número de la Respuesta Correcta"));
        panelCentro.add(textFieldRespuestaCorrecta);

        contentPane.add(panelCentro, BorderLayout.CENTER);

        // Panel inferior con los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Botón para agregar la pregunta
        btnAgregar = new JButton("Agregar Pregunta");
        panelBotones.add(btnAgregar);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPregunta();
            }
        });

        // Botón para volver al menú anterior
        btnVolver = new JButton("Volver");
        panelBotones.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAlMenu();
            }
        });

        contentPane.add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    // Método para agregar la nueva pregunta al banco de preguntas y actualizar el archivo CSV
    private void agregarPregunta() {
        String enunciado = textAreaPregunta.getText().trim();
        String respuestasTexto = textAreaRespuestas.getText().trim();
        String respuestaCorrectaTexto = textFieldRespuestaCorrecta.getText().trim();
        String[] alternativas = {"A", "B", "C", "D"};

        // Validar que los campos no estén vacíos
        if (enunciado.isEmpty() || respuestasTexto.isEmpty() || respuestaCorrectaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        // Validar que la respuesta correcta sea un número
        int numeroRespuestaCorrecta;
        try {
            numeroRespuestaCorrecta = Integer.parseInt(respuestaCorrectaTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El número de la respuesta correcta debe ser un número válido.");
            return;
        }

        // Dividir las respuestas por línea
        String[] respuestas = respuestasTexto.split("\\n");

        // Validar que el número de la respuesta correcta sea válido
        if (numeroRespuestaCorrecta < 1 || numeroRespuestaCorrecta > respuestas.length) {
            JOptionPane.showMessageDialog(this, "El número de la respuesta correcta no es válido.");
            return;
        }

        // Obtener la respuesta correcta según el número proporcionado
        String respuestaCorrecta = alternativas[numeroRespuestaCorrecta - 1];

        // Llamar a ObtenerDatos para agregar la nueva pregunta
        bancosPorTema = ObtenerDatos.agregarPregunta(bancoSeleccionado.getTema(), enunciado, respuestas, respuestaCorrecta, bancosPorTema);

        JOptionPane.showMessageDialog(this, "Pregunta agregada exitosamente.");

        // Limpiar los campos de texto para ingresar otra pregunta
        textAreaPregunta.setText("");
        textAreaRespuestas.setText("");
        textFieldRespuestaCorrecta.setText("");
    }

    // Método para volver al menú principal
    private void volverAlMenu() {
        new VentanaMenuExtras(materias, bancosPorTema, registroNotas, puntajesPracticas);
        dispose();
    }
}
