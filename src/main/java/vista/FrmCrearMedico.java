/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logica.Medico;
import logica.database.executeQueries;

/**
 *
 * @author danielneri
 */
public class FrmCrearMedico extends JFrame implements ActionListener
{
    private JTextField txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtCedula , txtEspecialidad  ;
    private JLabel lblNombre, lblApellidoPaterno, lblApellidoMaterno, lblCedula , lblEspecialidad ;
    private JButton btnGuardar, btnCancelar;

    public FrmCrearMedico() {
        super("Crear Medico");
        this.setLayout(null);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 10, 100, 30);
        this.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(120, 10, 200, 30);
        this.add(txtNombre);
        
        lblApellidoPaterno = new JLabel("Apellido Paterno");
        lblApellidoPaterno.setBounds(10, 50, 100, 30);
        this.add(lblApellidoPaterno);
        
        txtApellidoPaterno = new JTextField();
        txtApellidoPaterno.setBounds(120, 50, 200, 30);
        this.add(txtApellidoPaterno);
        
        lblApellidoMaterno = new JLabel("Apellido Materno");
        lblApellidoMaterno.setBounds(10, 90, 100, 30);
        this.add(lblApellidoMaterno);
        
        txtApellidoMaterno = new JTextField();
        txtApellidoMaterno.setBounds(120, 90, 200, 30);
        this.add(txtApellidoMaterno);
        
        lblCedula = new JLabel("Cedula");
        lblCedula.setBounds(10, 130, 100, 30);
        this.add(lblCedula);
        
        txtCedula = new JTextField();
        txtCedula.setBounds(120, 130, 200, 30);
        this.add(txtCedula);
        
        lblEspecialidad = new JLabel("Especialidad");
        lblEspecialidad.setBounds(10, 170, 100, 30);
        this.add(lblEspecialidad);
        
        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(120, 170, 200, 30);
        this.add(txtEspecialidad);
        
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 250, 100,
                30);
        btnGuardar.addActionListener(this);
        this.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(120, 250, 100,
                30);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            executeQueries eq = new executeQueries();
            Medico medico = new Medico(txtNombre.getText(), txtApellidoPaterno.getText() , txtApellidoMaterno.getText(), txtCedula.getText(), true);
            eq.CrearMedico(medico);
            FrmAdmin adm = new FrmAdmin();
            adm.setVisible(true);
            this.dispose();
        } else if (e.getSource() == btnCancelar) {
             FrmAdmin adm = new FrmAdmin();
            adm.setVisible(true);
            this.dispose();
        }
    }

    

}
