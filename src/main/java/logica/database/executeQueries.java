package logica.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import logica.ContactoEmergencia;

import logica.DbConnection;
import logica.Medicamento;
import logica.Medico;
import logica.Paciente;

public class executeQueries {

    public String login(String usuario, String contra) {
        try {
            Connection con = new DbConnection().getConnection();
            String query = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contra_usuario = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, usuario);
            pstmt.setString(2, contra);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("tipo_usuario");
            } else {
                throw new Exception("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            return "Error al obtener el usuario y la contraseña: " + e.getMessage();
        } finally {

        }

    }

    public Object pacientes() {
        //hacer una lista 
        List<Paciente> listaPacientes = new ArrayList<>();
        //regresar todos los pacientes de la base de datos en un arraylist
        String query = "SELECT * FROM Pacientes";
        try {
            Connection con = new DbConnection().getConnection();
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id_paciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                String nacimiento = rs.getString("fecha_nacimiento");
                String id_contacto = rs.getString("id_contacto");

                Paciente paciente = new Paciente(id_paciente, nombre, apellidoPaterno, apellidoMaterno, nacimiento, id_contacto);
                listaPacientes.add(paciente);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los pacientes: " + e.getMessage());
        }
        return listaPacientes;
    }

    public void CrearPaciente(Paciente paciente) {
        String query = "INSERT INTO Pacientes (nombre, apellido_paterno, apellido_materno, fecha_nacimiento, id_contacto) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = new DbConnection().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellidoPaterno());
            pstmt.setString(3, paciente.getApellidoMaterno());
            pstmt.setString(4, paciente.getNacimiento());
            pstmt.setString(5, paciente.getId_contacto());

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar " + e.getMessage());
        }
    }

    public void CrearContacto(ContactoEmergencia contacto) {
        String query = "INSERT INTO Contactos(nombre, apellido_paterno, apellido_materno, telefono, parentesco) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = new DbConnection().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidoPaterno());
            pstmt.setString(3, contacto.getApellidoMaterno());
            pstmt.setString(4, contacto.getTelefono());
            pstmt.setString(5, contacto.getParentesco());

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar " + e.getMessage());
        }
    }

    public void CrearMedicamento(Medicamento medicamento) {
        String query = "INSERT INTO Medicamentos(nombre, presentacion, modo_empleo, fabricante, cantidad, unidad_cantidad) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection con = new DbConnection().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, medicamento.getNombre());
            pstmt.setString(2, medicamento.getPresentacion());
            pstmt.setString(3, medicamento.getModo_empleo());
            pstmt.setString(4, medicamento.getFabricante());
            pstmt.setInt(5, medicamento.getCantidad());
            pstmt.setString(6, medicamento.getUnidad_cantidad());

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar " + e.getMessage());
        }
    }

    public void CrearMedico(Medico medico) {
        String query = "INSERT INTO Medicos(nombre, apellido_paterno, apellido_materno, cedula, status) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = new DbConnection().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, medico.getNombre());
            pstmt.setString(2, medico.getApellido_paterno());
            pstmt.setString(3, medico.getApellido_materno());
            pstmt.setString(4, medico.getCedula());
            pstmt.setBoolean(5, true);

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al guardar " + e.getMessage());
        }
    }

    public Object listaMedicos() {
        //hacer una lista 
        List<Medico> listaMedicos = new ArrayList<>();
        //regresar todos los pacientes de la base de datos en un arraylist
        String query = "SELECT * FROM Medicos";
        try {
            Connection con = new DbConnection().getConnection();
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                String cedula = rs.getString("cedula");
                boolean status = rs.getBoolean("status");

                Medico medico = new Medico(nombre, apellidoPaterno, apellidoMaterno, cedula, status);
                listaMedicos.add(medico);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los medicos: " + e.getMessage());
        }
        return listaMedicos;
    }

    public Paciente obtenerPacienteId(String numero) {
        Paciente paciente = new Paciente();
        String query = "SELECT * FROM Pacientes WHERE id_paciente = ?";
        try {
            Connection con = new DbConnection().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, numero);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String apellidoMaterno = rs.getString("apellido_materno");
                String nacimiento = rs.getString("fecha_nacimiento");
                String id_contacto = rs.getString("id_contacto");

                paciente = new Paciente(nombre, apellidoPaterno, apellidoMaterno, nacimiento, id_contacto);

                

            }
        } catch (Exception e) {
            System.out.println("Error al buscar paciente " + e.getMessage());
        }
        return paciente;
    }

}
