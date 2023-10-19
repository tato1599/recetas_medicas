package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIniciarSesion;
    
    public FrmLogin() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblUsuario = new JLabel("Usuario:");
        panel.add(lblUsuario, gbc);
        
        gbc.gridy = 1;
        txtUsuario = new JTextField(20);
        panel.add(txtUsuario, gbc);
        
        gbc.gridy = 2;
        JLabel lblContrasena = new JLabel("Contraseña:");
        panel.add(lblContrasena, gbc);
        
        gbc.gridy = 3;
        txtContrasena = new JPasswordField(20);
        panel.add(txtContrasena, gbc);
        
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        btnIniciarSesion = new JButton("Iniciar Sesión");
        panel.add(btnIniciarSesion, gbc);
        
        gbc.gridx = 1;
        JButton btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar, gbc);
        
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    


}
