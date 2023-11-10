/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author danielneri
 */
public class Medicamento {
    private String nombre;
    private String presentacion;
    private String modo_empleo;
    private String fabricante;
    private int cantidad;
    private String unidad_cantidad;

    public Medicamento(String nombre, String presentacion, String modo_empleo, String fabricante, int cantidad, String unidad_cantidad) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.modo_empleo = modo_empleo;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.unidad_cantidad = unidad_cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getModo_empleo() {
        return modo_empleo;
    }

    public void setModo_empleo(String modo_empleo) {
        this.modo_empleo = modo_empleo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad_cantidad() {
        return unidad_cantidad;
    }

    public void setUnidad_cantidad(String unidad_cantidad) {
        this.unidad_cantidad = unidad_cantidad;
    }
    
    
}
