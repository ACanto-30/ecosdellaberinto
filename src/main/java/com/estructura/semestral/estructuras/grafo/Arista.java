/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura.semestral.estructuras.grafo;

class Arista {
    int destino;
    int peso;

    Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
    
    public int getPeso()
    {
        return this.peso;
    }
    
    public int getDestino() {
            return destino;
        }
}