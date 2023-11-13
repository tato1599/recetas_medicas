/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import logica.Medicamento;
import logica.database.executeQueries;

/**
 *
 * @author danielneri
 */
public class FrmCrearMedicamento extends JFrame implements ActionListener
{
    private JTextField txtNombre, txtPresentacion, txtModoEmpleo, txtFabricante, txtCantidad,txtUnidadCantidad;
    private JLabel lblNombre, lblPresentacion, lblModoEmpleo, lblFabricante, lblCantidad, lblUnidadCantidad;
    private JButton btnGuardar, btnCancelar;

    public FrmCrearMedicamento() {
        super("Crear Medicamento");
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
        
        lblPresentacion = new JLabel("Presentacion");
        lblPresentacion.setBounds(10, 50, 100, 30);
        this.add(lblPresentacion);
        
        txtPresentacion = new JTextField();
        txtPresentacion.setBounds(120, 50, 200, 30);
        this.add(txtPresentacion);
        
        lblModoEmpleo = new JLabel("Modo de empleo");
        lblModoEmpleo.setBounds(10, 90, 100, 30);
        this.add(lblModoEmpleo);
        
        txtModoEmpleo = new JTextField();
        txtModoEmpleo.setBounds(120, 90, 200, 30);
        this.add(txtModoEmpleo);
        
        lblFabricante = new JLabel("Fabricante");
        lblFabricante.setBounds(10, 130, 100, 30);
        this.add(lblFabricante);
        
        txtFabricante = new JTextField();
        txtFabricante.setBounds(120, 130, 200, 30);
        this.add(txtFabricante);
        
        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setBounds(10, 170, 100, 30);
        this.add(lblCantidad);
        
        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 170, 200, 30);
        this.add(txtCantidad);

        lblUnidadCantidad = new JLabel("Unidad de cantidad");
        lblUnidadCantidad.setBounds(10, 210, 100, 30);
        this.add(lblUnidadCantidad);

        txtUnidadCantidad = new JTextField();

        txtUnidadCantidad.setBounds(120, 210, 200, 30);

        this.add(txtUnidadCantidad);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 250, 100, 30);
        btnGuardar.addActionListener(this);
        this.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(120, 250, 100, 30);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGuardar){
            //guardar en la base de datos
            executeQueries queries = new executeQueries();
            Medicamento medicamento = new Medicamento(txtNombre.getText(), txtPresentacion.getText(), txtModoEmpleo.getText(), txtFabricante.getText(), Integer.parseInt(txtCantidad.getText()), txtUnidadCantidad.getText());
            queries.CrearMedicamento(medicamento);  
            FrmAdmin adm = new FrmAdmin();
            adm.setVisible(true);
            this.dispose();
        }
        if(e.getSource() == btnCancelar){
    
       FrmAdmin frmAdministrador = new FrmAdmin();
       frmAdministrador.setVisible(true);
         this.dispose();

     }
    }

}
