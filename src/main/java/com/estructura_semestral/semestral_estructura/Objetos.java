/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura_semestral.semestral_estructura;

/**
 *
 * @author abrah
 */
public class Objetos {
    public int cantidad;
    public String nombre;
    public String efecto;

    public Objetos(int cantidad, String nombre, String efecto) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
    
    
}
