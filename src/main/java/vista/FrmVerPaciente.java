package vista;

import logica.Paciente;

import javax.swing.*;

public class FrmVerPaciente extends JFrame
{
    FrmVerPaciente(Paciente paciente)
    {
        initComponents();
    }

    private void initComponents() {
        setTitle("Ver Paciente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
    }


}
