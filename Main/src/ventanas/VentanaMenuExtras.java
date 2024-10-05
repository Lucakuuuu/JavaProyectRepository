package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Codigo.BancoPreguntas;
import Codigo.Nota;
import Codigo.Puntajes;

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
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Llamar al método para mostrar las opciones del menú
        mostrarMenu("Selecciona una opción", new String[]{"Solucionario", "Editor de preguntas"}, 300, 200);
    }

    // Método para mostrar las opciones del menú
    private void mostrarMenu(String mensaje, String[] opciones, int ancho, int alto) {
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(opciones.length, 1));
        panelMenu.setBorder(BorderFactory.createTitledBorder(mensaje));

        // Crear los botones para cada opción
        for (String opcion : opciones) {
            JButton btnOpcion = new JButton(opcion);
            btnOpcion.addActionListener(e -> opcionSeleccionada(opcion));
            panelMenu.add(btnOpcion);
        }

        contentPane.add(panelMenu);
        panelMenu.setBounds(50, 50, ancho, alto);
        setVisible(true);
    }

    // Método que se ejecuta cuando se selecciona una opción
    private void opcionSeleccionada(String opcion) {
        JOptionPane.showMessageDialog(this, "Has seleccionado: " + opcion);
        // Aquí puedes agregar lógica para abrir otras ventanas o realizar acciones según la opción seleccionada
    }
}
