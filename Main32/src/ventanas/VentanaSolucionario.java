package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Codigo.BancoPreguntas;
import Codigo.Nota;
import Codigo.Puntajes;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VentanaSolucionario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaSolucionario;

    public VentanaSolucionario(Set<String> materias, Map<String, BancoPreguntas> bancosPorTema, List<Nota> registroNotas, List<Puntajes> puntajesPracticas, String nombreArchivo, BancoPreguntas bancoSeleccionado) {
        setTitle("Solucionario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Aumentar el tamaño de la ventana
        setBounds(100, 100, 1200, 800);  // Cambiado de 500x400 a 1200x800
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Crear el área de texto para mostrar el solucionario
        textAreaSolucionario = new JTextArea();
        textAreaSolucionario.setEditable(false); // Hacer que el área de texto no sea editable
        textAreaSolucionario.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaSolucionario.setText(leerArchivoCSV("src/Preguntas/" + nombreArchivo + ".csv"));

        // Añadir el área de texto a un panel de scroll para permitir desplazarse por el solucionario
        JScrollPane scrollPane = new JScrollPane(textAreaSolucionario);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Añadir el listener para regresar a VentanaMenuExtras al cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new VentanaMenuExtras(materias, bancosPorTema, registroNotas, puntajesPracticas);
            }
        });

        setVisible(true);
    }

    // Método para leer el archivo CSV y retornar los datos formateados como texto
    public String leerArchivoCSV(String nombreArchivo) {
        StringBuilder solucionario = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] parte = linea.split(";");
                // Formatear el texto del solucionario
                solucionario.append("------------------ o ------------------\n");
                solucionario.append("Asignatura: ").append(parte[0]).append("\n");
                solucionario.append("Tema: ").append(parte[1]).append("\n");
                solucionario.append("Pregunta: ").append(parte[2]).append("\n");
                solucionario.append("A) ").append(parte[3]).append("\n");
                solucionario.append("B) ").append(parte[4]).append("\n");
                solucionario.append("C) ").append(parte[5]).append("\n");
                solucionario.append("D) ").append(parte[6]).append("\n");
                solucionario.append("Respuesta: ").append(parte[7]).append("\n");
                solucionario.append("\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        }
        return solucionario.toString();
    }
}

