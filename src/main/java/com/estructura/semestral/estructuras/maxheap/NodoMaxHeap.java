/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura.semestral.estructuras.maxheap;

public class NodoMaxHeap {
    int nivel;
    String nombre;
    String efecto;

    public NodoMaxHeap(int nivel, String nombre, String efecto) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre + ", Efecto: " + efecto + ", Nivel: " + nivel);
    }
}
