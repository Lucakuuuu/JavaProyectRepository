package VentanasDeMenus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;

import VentanasDeSeleccion.*;
import VentanasDeMenus.*;
import VentanasDeAcciones.*;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VentanaMenuExtras extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaMenuExtras(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Menú extras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo la ventana de extras
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);  // Fondo blanco para mantener consistencia
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Seleccione una opción");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setToolTipText("Elije una opción");
        lblNewLabel.setBounds(189, 80, 306, 44);
        contentPane.add(lblNewLabel);
        
        // Botón "Realizar evaluación"
        JButton btnSolucionario = new JButton("Solucionario");
        btnSolucionario.setForeground(Color.WHITE);
        btnSolucionario.setBackground(Color.BLACK);
        btnSolucionario.setBounds(189, 150, 306, 30);
        contentPane.add(btnSolucionario);
        
        JButton btnEditorPreguntas = new JButton("Editor de preguntas");
        btnEditorPreguntas.setForeground(Color.WHITE);
        btnEditorPreguntas.setBackground(Color.BLACK);
        btnEditorPreguntas.setBounds(189, 190, 306, 30);
        contentPane.add(btnEditorPreguntas);

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(Color.BLACK);
        btnRegresar.setBounds(189, 230, 306, 30);
        contentPane.add(btnRegresar);

        // Acción para regresar al menú principal
        btnRegresar.addActionListener(e -> {
            new VentanaMenuPrincipal(materias, bancosPorTema, registroNotas, puntajesPracticas);  // Volver al menú principal
            dispose();  // Cerrar la ventana actual
        });
        
        btnSolucionario.addActionListener(e -> {
        	new VentanaSeleccionSolucionario(materias, bancosPorTema, registroNotas, puntajesPracticas);
            dispose();  // Cerrar la ventana actual
        });
        
        btnEditorPreguntas.addActionListener(e -> {
            new VentanaMenuEditorPreguntas(materias, bancosPorTema, registroNotas, puntajesPracticas);  // Volver al menú principal
            dispose();  // Cerrar la ventana actual
        });

        setVisible(true);
    }
    
    
}
