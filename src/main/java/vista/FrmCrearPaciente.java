package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import logica.Paciente;
import logica.database.executeQueries;

public class FrmCrearPaciente extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtFechaNacimiento;
    private JPanel formulario;
    private JButton btnCancelar, btnGuardar;

    public FrmCrearPaciente() {
        initComponents();
        formulario();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); // Evita el cierre automático
        setTitle("Crear Paciente");
        setResizable(false);
        setSize(500, 400);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Acciones cuando se intenta cerrar la ventana
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro que deseas cancelar y volver a la ventana anterior?",
                        "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    FrmMedico ventana = new FrmMedico();
                    ventana.setVisible(true);
                    dispose(); // Cierra la ventana actual
                }
            }
        });
        
        setVisible(true);
    }

private void formulario() {
    formulario = new JPanel(new BorderLayout());

    JPanel panelCampos = new JPanel(new GridBagLayout());
    JPanel panelBotones = new JPanel();

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);

    // Etiquetas para los campos
    JLabel lblNombre = new JLabel("Nombre:");
    JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
    JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
    JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");

    // Campos de texto con 10 columnas
    txtNombre = new JTextField(10);
    txtApellidoPaterno = new JTextField(10);
    txtApellidoMaterno = new JTextField(10);
    txtFechaNacimiento = new JTextField(10);

    // Botones
    btnGuardar = new JButton("Guardar");
    btnGuardar.addActionListener(this);
    btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(this);

    gbc.gridx = 0;
    gbc.gridy = 0;
    panelCampos.add(lblNombre, gbc);

    gbc.gridy++;
    panelCampos.add(lblApellidoPaterno, gbc);

    gbc.gridy++;
    panelCampos.add(lblApellidoMaterno, gbc);

    gbc.gridy++;
    panelCampos.add(lblFechaNacimiento, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    panelCampos.add(txtNombre, gbc);

    gbc.gridy++;
    panelCampos.add(txtApellidoPaterno, gbc);

    gbc.gridy++;
    panelCampos.add(txtApellidoMaterno, gbc);

    gbc.gridy++;
    panelCampos.add(txtFechaNacimiento, gbc);

    panelBotones.add(btnGuardar);
    panelBotones.add(btnCancelar);

    formulario.add(panelCampos, BorderLayout.CENTER);
    formulario.add(panelBotones, BorderLayout.SOUTH);

    add(formulario);
}


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCancelar) {
            // Acciones cuando se intenta cerrar la ventana
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro que deseas cancelar y volver a la ventana anterior?",
                    "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                FrmMedico ventana = new FrmMedico();
                ventana.setVisible(true);
                dispose();
            }
        }

        if (e.getSource() == btnGuardar) {

            int confirmed = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro que deseas guardar los datos del paciente?",
                    "Confirmar guardado", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {

                executeQueries consulta = new executeQueries();

                String nombre = txtNombre.getText();
                String apellidoPaterno = txtApellidoPaterno.getText();
                String apellidoMaterno = txtApellidoMaterno.getText();
                String fechaNacimiento = txtFechaNacimiento.getText();

                Paciente paciente = new Paciente(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, null);

                consulta.CrearPaciente(paciente);

                JOptionPane.showMessageDialog(null, "Paciente guardado con éxito");

                FrmMedico ventana = new FrmMedico();
                ventana.setVisible(true);
                dispose();
            }
        }

    }
}
