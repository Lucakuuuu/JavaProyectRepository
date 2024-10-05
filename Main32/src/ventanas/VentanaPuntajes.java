package ventanas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Codigo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

class VentanaPuntajes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaPuntajes(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas) {
        setTitle("Puntajes Obtenidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPuntajes = new JLabel("Puntajes Obtenidos");
        lblPuntajes.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuntajes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPuntajes.setBounds(50, 30, 300, 30);
        contentPane.add(lblPuntajes);

        // Tabla con los puntajes obtenidos (ejemplo)
        String[] columnNames = { "Materia", "Puntaje", "Máx. Puntaje" };
        Object[][] data = {
            { "Matemáticas", "85", "100" },
            { "Historia", "90", "100" },
            { "Ciencias", "78", "100" }
        };
        JTable tablePuntajes = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tablePuntajes);
        scrollPane.setBounds(50, 80, 300, 100);
        contentPane.add(scrollPane);

        // Botón para volver al menú de prácticas
        JButton btnVolverMenuPracticas = new JButton("Volver al Menú de Prácticas");
        btnVolverMenuPracticas.setForeground(Color.WHITE);
        btnVolverMenuPracticas.setBackground(Color.BLACK);
        btnVolverMenuPracticas.setBounds(100, 200, 200, 30);
        contentPane.add(btnVolverMenuPracticas);

        // Acción al presionar el botón de volver
        btnVolverMenuPracticas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VentanaMenuPracticas(materias, bancosPorTema, registroNotas, puntajesPracticas);
            }
        });

        setVisible(true);
    }
}
