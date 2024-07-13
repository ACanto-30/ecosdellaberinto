/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura.semestral.estructuras.arbol;

import java.util.List;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public synchronized void insertarNodo(int valorInsertar, String nombre, String efecto, int costo, float estadistica) {
        if (raiz == null) {
            raiz = new NodoArbol(valorInsertar, nombre, efecto, costo, estadistica);
        } else {
            raiz.insertarHijo(valorInsertar, nombre, efecto, costo, estadistica);
        }
    }

    public synchronized void insertarEnNodo(int valorPadre, int valorInsertar, String nombre, String efecto, int costo, float estadistica) {
        NodoArbol nodoPadre = buscarNodo(raiz, valorPadre);
        if (nodoPadre != null) {
            nodoPadre.insertarHijo(valorInsertar, nombre, efecto, costo, estadistica);
        } else {
            System.out.println("Nodo padre no encontrado.");
        }
    }

    private NodoArbol buscarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (nodo.datos == valor) {
            return nodo;
        }
        for (NodoArbol hijo : nodo.getHijos()) {
            NodoArbol resultado = buscarNodo(hijo, valor);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    public String[] obtenerInfoNodo(int valorNodo) {
        NodoArbol nodo = buscarNodo(raiz, valorNodo);
        if (nodo != null) {
            return new String[] {
                nodo.getNombre(),
                nodo.getEfecto(),
                String.valueOf(nodo.getCosto()),
                String.valueOf(nodo.getEstadistica())
            };
        } else {
            return new String[] { "Nodo no encontrado", "", "", "" };
        }
    }

    public NodoArbol buscarNodoPorNombre(String nombre) {
        return buscarNodoPorNombre(raiz, nombre);
    }

    private NodoArbol buscarNodoPorNombre(NodoArbol nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getNombre().equals(nombre)) {
            return nodo;
        }
        for (NodoArbol hijo : nodo.getHijos()) {
            NodoArbol resultado = buscarNodoPorNombre(hijo, nombre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

}