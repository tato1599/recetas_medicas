/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.JOptionPane;

import logica.database.executeQueries;
import vista.FrmAdmin;
import vista.FrmLogin;
import vista.FrmMedico;

/**
 *
 * @author danielneri
 */
public class appRecetas {
 public static void main(String[] args) {
        FrmLogin ventana = new FrmLogin();
        executeQueries eq = new executeQueries();
        ventana.setVisible(true);

        ventana.getBtnIniciarSesion().addActionListener((e) -> {
            String usuario = ventana.getTxtUsuario().getText();
            String contra = ventana.getTxtContrasena().getText();
            String tipoUsuario = eq.login(usuario, contra);
            System.out.println(tipoUsuario);

            if (tipoUsuario.equals("0")) {
                FrmAdmin frmAdmin = new FrmAdmin();
                frmAdmin.setVisible(true);
                ventana.dispose(); 
            } else if (tipoUsuario.equals("1")) {
                FrmMedico frmMedico = new FrmMedico();
                frmMedico.setVisible(true);
                ventana.dispose(); 
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        });
    }
}
