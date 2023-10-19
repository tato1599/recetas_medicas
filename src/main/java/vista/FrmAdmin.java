package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class FrmAdmin extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuOpciones;
    private JMenuItem menuItemCerrarSesion;
    private JTabbedPane tabbedPane;
    private JPanel panelMedicos;
    private JPanel panelMedicamentos;
    private JLabel lblNombreMedico;
    private JTextField txtNombreMedico;
    private JLabel lblNombreMedicamento;
    private JTextField txtNombreMedicamento;
    private JButton btnAltaMedico;
    private JButton btnAltaMedicamento;

    public FrmAdmin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Panel de Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Menú
        menuBar = new JMenuBar();
        menuOpciones = new JMenu("Opciones");
        menuItemCerrarSesion = new JMenuItem("Cerrar Sesión");
        menuOpciones.add(menuItemCerrarSesion);
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        // Pestañas para médicos y medicamentos
        tabbedPane = new JTabbedPane();

        // Panel para médicos
        panelMedicos = new JPanel();
        lblNombreMedico = new JLabel("Nombre del Médico:");
        txtNombreMedico = new JTextField(20);
        btnAltaMedico = new JButton("Dar de Alta Médico");
        panelMedicos.add(lblNombreMedico);
        panelMedicos.add(txtNombreMedico);
        panelMedicos.add(btnAltaMedico);
        tabbedPane.addTab("Médicos", panelMedicos);

        // Panel para medicamentos
        panelMedicamentos = new JPanel();
        lblNombreMedicamento = new JLabel("Nombre del Medicamento:");
        txtNombreMedicamento = new JTextField(20);
        btnAltaMedicamento = new JButton("Dar de Alta Medicamento");
        panelMedicamentos.add(lblNombreMedicamento);
        panelMedicamentos.add(txtNombreMedicamento);
        panelMedicamentos.add(btnAltaMedicamento);
        tabbedPane.addTab("Medicamentos", panelMedicamentos);

        add(tabbedPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }
}
