package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VentanaSeleccionPracticas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaSeleccionPracticas(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Puntajes> puntajesPracticas) {
        setTitle("Iniciar Práctica");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta para seleccionar materia
        JLabel lblSeleccionarMateria = new JLabel("Selecciona una Materia");
        lblSeleccionarMateria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarMateria.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSeleccionarMateria.setBounds(50, 30, 300, 30);
        contentPane.add(lblSeleccionarMateria);

        // ComboBox para seleccionar la materia
        String[] materiasArray = materias.toArray(new String[0]);
        JComboBox<String> comboMaterias = new JComboBox<>(materiasArray);
        comboMaterias.setBounds(100, 80, 200, 30);
        contentPane.add(comboMaterias);

        // Botón para iniciar la práctica
        JButton btnIniciarPractica = new JButton("Iniciar Práctica");
        btnIniciarPractica.setForeground(Color.WHITE);
        btnIniciarPractica.setBackground(Color.BLACK);
        btnIniciarPractica.setBounds(100, 150, 200, 30);
        contentPane.add(btnIniciarPractica);

        setVisible(true);

        // Acción al presionar el botón de iniciar práctica
        btnIniciarPractica.addActionListener(e -> {
                String materiaSeleccionada = (String) comboMaterias.getSelectedItem();
                BancoPreguntas bancoSeleccionado = bancosPorTema.get(materiaSeleccionada);
                Evaluacion evaluacion = new Evaluacion(bancoSeleccionado);
                JOptionPane.showMessageDialog(this, "Iniciando Práctica de " + materiaSeleccionada);
                new VentanaPracticas(evaluacion, materiaSeleccionada, puntajesPracticas);
        });
    }
}
