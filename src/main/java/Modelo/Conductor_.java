/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigInteger;

/**
 *
 * @author Santiago
 */
public class Conductor_ {
    
   private String nombre;
   private String apellido;
   private int cedula;
   private String  celular;
   private Estado_ estado;
   
    public Conductor_(String nombre, String apellido, int cedula, String celular, Estado_ estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
        this.estado = estado;
    }

    public Estado_ getEstado() {
        return estado;
    }

    public void setEstado(Estado_ estado) {
        this.estado = estado;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
}
