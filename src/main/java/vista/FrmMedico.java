package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmMedico extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JButton btnCrearReceta;
    private JTable tablaPacientes;

    public FrmMedico() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Ventana Principal del Médico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Menú
        menuBar = new JMenuBar();
        menu = new JMenu("Opciones");
        menuItem = new JMenuItem("Opción 1");
        menu.add(menuItem);
        menuItem = new JMenuItem("Opción 2");
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Botón para crear recetas
        btnCrearReceta = new JButton("Crear Receta");

        // Tabla de pacientes
        String[] columnas = {"Nombre", "Edad", "Diagnóstico"};
        Object[][] datos = {
            {"Paciente 1", 30, "Enfermedad X"},
            {"Paciente 2", 25, "Enfermedad Y"},
            {"Paciente 3", 40, "Enfermedad Z"}
        };
        tablaPacientes = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(btnCrearReceta, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setLocationRelativeTo(null);
    }
}
