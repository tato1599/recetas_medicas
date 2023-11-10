package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.Paciente;
import java.util.List;

import logica.database.executeQueries;

public class FrmMedico extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JButton btnCrearReceta,btnCrearPaciente;
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
        menuItem = new JMenuItem("Cerrar Sesión");
        menuItem.addActionListener((e) -> {
            FrmLogin frmLogin = new FrmLogin();
            frmLogin.setVisible(true);
            dispose();
        });
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Botón para crear recetas
        btnCrearPaciente = new JButton("Crear pacientes");
        btnCrearPaciente.addActionListener(this);
        btnCrearReceta = new JButton("Crear Receta");

        //crear un panel para agrupar los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCrearPaciente);
        
        panelBotones.add(btnCrearReceta);


        executeQueries query = new executeQueries();
      
        // Tabla de pacientes
        String[] columnas = {"Nombre", "Apellido Paterno", "Apellido Materno","Nacimiento"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        List<Paciente> pacientes = (List<Paciente>) query.pacientes(); 

        for (Paciente paciente : pacientes) {
            Object[] rowData = { paciente.getNombre(), paciente.getApellidoPaterno(), paciente.getApellidoMaterno(), paciente.getNacimiento() };
            model.addRow(rowData);
        }

        tablaPacientes = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(panelBotones, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCrearPaciente){
            FrmCrearPaciente frmCrearPaciente = new FrmCrearPaciente();
            frmCrearPaciente.setVisible(true);
            dispose();
        }
    }
}
