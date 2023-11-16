/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author danielneri
 */
public class Paciente {
    private int id_paciente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nacimiento;
    private String id_contacto;

    public Paciente() {
    }
    
    

    public Paciente(int id_paciente, String nombre, String apellidoPaterno, String apellidoMaterno, String nacimiento, String id_contacto) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nacimiento = nacimiento;
        this.id_contacto = id_contacto;
    }

    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, String nacimiento, String id_contacto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nacimiento = nacimiento;
        this.id_contacto = id_contacto;
    }
    
    

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    
    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setId_contacto(String id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getId_contacto() {
        return id_contacto;
    }

    @Override
    public String toString() {
        return "Paciente" + ", Nombre: " + nombre + ", Apellido Paterno: " + apellidoPaterno + ", Apellido Materno: " + apellidoMaterno + ", Nacimiento: " + nacimiento + ", id_contacto: " + id_contacto;
    }
    
    
}
