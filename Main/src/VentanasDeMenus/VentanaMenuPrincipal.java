package VentanasDeMenus;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.*;
import Codigo.BancoPreguntas;
import Codigo.Nota;
import Codigo.Puntajes;

import VentanasDeSeleccion.*;
import VentanasDeMenus.*;
import VentanasDeAcciones.*;

public class VentanaMenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaMenuPrincipal(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Etiqueta de bienvenida
        JLabel lblNewLabel = new JLabel("Bienvenido");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblNewLabel.setToolTipText("Elije una opción");
        lblNewLabel.setBounds(189, 80, 306, 44);
        contentPane.add(lblNewLabel);
        
        // Botón "Realizar evaluación"
        JButton btnRealizarEvaluacion = new JButton("Realizar evaluación");
        btnRealizarEvaluacion.setForeground(Color.WHITE);
        btnRealizarEvaluacion.setBackground(Color.BLACK);
        btnRealizarEvaluacion.setBounds(189, 150, 306, 30);
        contentPane.add(btnRealizarEvaluacion);
        
        JButton btnRegistroDeNotas = new JButton("Registro de notas");
        btnRegistroDeNotas.setForeground(Color.WHITE);
        btnRegistroDeNotas.setBackground(Color.BLACK);
        btnRegistroDeNotas.setBounds(189, 190, 306, 30);
        contentPane.add(btnRegistroDeNotas);

        // Botón "Registro de notas"
        JButton btnPracticas = new JButton("Prácticas");
        btnPracticas.setForeground(Color.WHITE);
        btnPracticas.setBackground(Color.BLACK);
        btnPracticas.setBounds(189, 230, 306, 30);
        contentPane.add(btnPracticas);
        
        // Botón "Extras"
        JButton btnExtras = new JButton("Extras");
        btnExtras.setForeground(Color.WHITE);
        btnExtras.setBackground(Color.BLACK);
        btnExtras.setBounds(189, 270, 306, 30);
        contentPane.add(btnExtras);

        // Botón "Cerrar aplicación"
        JButton btnCerrar = new JButton("Cerrar aplicación");
        btnCerrar.addActionListener(e -> System.exit(0));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setBackground(Color.BLACK);
        btnCerrar.setBounds(189, 310, 306, 30);
        contentPane.add(btnCerrar);

        // Acción para iniciar evaluación
        btnRealizarEvaluacion.addActionListener(e -> {
        	new VentanaSeleccionEvaluacion(materias, bancosPorTema, registroNotas, puntajesPracticas);
        	dispose();
        	}
        );

        // Acción para ver registro de notas
        btnRegistroDeNotas.addActionListener(e -> {
        	new VentanaSeleccionRegistroNotas(materias, bancosPorTema, registroNotas, puntajesPracticas);
        	dispose();
        	}
        );
        
        // Acción para ir a "Prácticas"
        btnPracticas.addActionListener(e -> {
        	new VentanaMenuPracticas(materias, bancosPorTema, registroNotas, puntajesPracticas);
        	dispose();
    		}
        );

        // Acción para ir a "Extras"
        btnExtras.addActionListener(e -> {
        	new VentanaMenuExtras(materias, bancosPorTema, registroNotas, puntajesPracticas);
        	dispose();
        	}
        );
        
        // Mostrar la ventana
        setVisible(true);
    }
}
