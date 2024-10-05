package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import Codigo.*;

public class VentanaModificarRespuestas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField[] respuestasFields;
    private JTextField campoRespuestaCorrecta;
    private JButton btnConfirmar;
    private Pregunta pregunta;
    private BancoPreguntas bancoSeleccionado;
    private Map<String, BancoPreguntas> bancosPorTema;

    public VentanaModificarRespuestas(Pregunta pregunta, BancoPreguntas bancoSeleccionado, Map<String, BancoPreguntas> bancosPorTema) {
        this.pregunta = pregunta;
        this.bancoSeleccionado = bancoSeleccionado;
        this.bancosPorTema = bancosPorTema;

        setTitle("Modificar Respuestas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(6, 2));

        // Crear campos para editar respuestas
        String[] respuestas = pregunta.getRespuestas();
        respuestasFields = new JTextField[respuestas.length];
        for (int i = 0; i < respuestas.length; i++) {
            JLabel label = new JLabel("Respuesta " + (i + 1) + ":");
            respuestasFields[i] = new JTextField(respuestas[i]);
            contentPane.add(label);
            contentPane.add(respuestasFields[i]);
        }

        // Campo para la respuesta correcta
        JLabel lblRespuestaCorrecta = new JLabel("Respuesta Correcta:");
        campoRespuestaCorrecta = new JTextField(pregunta.getRespuestaCorrecta());
        contentPane.add(lblRespuestaCorrecta);
        contentPane.add(campoRespuestaCorrecta);

        // Botón de confirmación
        btnConfirmar = new JButton("Confirmar Modificación");
        contentPane.add(btnConfirmar);
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarRespuestas();
            }
        });

        setVisible(true);
    }

    // Método para modificar las respuestas y la respuesta correcta
    private void modificarRespuestas() {
        String[] nuevasRespuestas = new String[respuestasFields.length];
        for (int i = 0; i < respuestasFields.length; i++) {
            nuevasRespuestas[i] = respuestasFields[i].getText();
        }

        String nuevaRespuestaCorrecta = campoRespuestaCorrecta.getText();

        // Actualizar la pregunta con las nuevas respuestas
        pregunta.setRespuestas(nuevasRespuestas);
        pregunta.setRespuestaCorrecta(nuevaRespuestaCorrecta);

        // Actualizar el banco de preguntas
        bancosPorTema.put(bancoSeleccionado.getTema(), bancoSeleccionado);
        JOptionPane.showMessageDialog(this, "Respuestas modificadas exitosamente.");
        dispose(); // Cerrar la ventana después de confirmar
    }
}
