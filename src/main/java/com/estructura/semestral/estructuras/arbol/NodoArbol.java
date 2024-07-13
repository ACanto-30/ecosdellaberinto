/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura.semestral.estructuras.arbol;

import java.util.ArrayList;
import java.util.List;

public class NodoArbol {
    public int datos;
    String nombre;
    String efecto;
    int costo;
    List<NodoArbol> hijos;
    double estadistica;
    NodoArbol padre; 

    public NodoArbol(int datosNodo, String nombreNodo, String efectoNodo, int costo, double estadistica) {
        this.datos = datosNodo;
        this.nombre = nombreNodo;
        this.efecto = efectoNodo;
        this.costo = costo;
        this.hijos = new ArrayList<>();
        this.estadistica = estadistica;
        this.padre = null; 
    }

    public void insertarHijo(int valorInsertar, String nombreInsertar, String efectoInsertar, int costo, float estadistica) {
        NodoArbol hijo = new NodoArbol(valorInsertar, nombreInsertar, efectoInsertar, costo, estadistica);
        hijo.padre = this; 
        hijos.add(hijo);
    }

    public List<NodoArbol> getHijos() {
        return hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getCosto() {
        return costo;
    }

    public double getEstadistica() {
        return estadistica;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public String getNombrePadre() {
        return padre != null ? padre.getNombre() : null;
    }
}
