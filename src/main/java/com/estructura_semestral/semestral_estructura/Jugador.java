/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura_semestral.semestral_estructura;



import java.util.ArrayList;
import com.estructura.semestral.estructuras.arbol.NodoArbol;
import com.estructura.semestral.estructuras.arbol.Arbol;
/**
 *
 * @author abrah
 */
public class Jugador {
    
    public double velocidad;
    public int cordura;
    public double hambre;
    public int piernas;
    public double cansancio;
    public int salud;
    public int experiencia;
    public ArrayList<Objetos> objetos;
    private Arbol habilidadesAdquiridas;
    
    public Jugador(double velocidad, int cordura, double hambre, int piernas, double cansancio, int salud, ArrayList<Objetos> objetos) {
        this.velocidad = velocidad;
        this.cordura = cordura;
        this.hambre = hambre;
        this.piernas = piernas;
        this.cansancio = cansancio;
        this.salud = salud;
        this.objetos = objetos;
        this.habilidadesAdquiridas = new Arbol();
    }

    public Jugador(){
    }
 
    
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad, double hambre, int piernas, double cansancio) {
        this.velocidad = velocidad - (hambre / 100) - (piernas / 50) - (cansancio / 75);
    }

    public int getCordura() {
        return cordura;
    }

    public void setCordura(int cordura) {
        this.cordura += cordura;
    }

    public double getHambre() {
        return hambre;
    }

    public void setHambre(double hambre) {
        this.hambre += hambre;
    }

    public int getPiernas() {
        return piernas;
    }

    public void setPiernas(int piernas) {
        this.piernas += piernas;
    }

    public double getCansancio() {
        return cansancio;
    }

    public void setCansancio(double cansancio) {
        this.cansancio += cansancio;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud += salud;
    }
    
    public int getExperiencia()
    {
        return experiencia;
    }
    
    public void setExperiencia(int experiencia)
    {
        this.experiencia += experiencia;
    }
    
    public void setObjetos(int cantidad, String nombre, String efecto)
    {
        objetos.add(new Objetos(cantidad, nombre, efecto));
    }
    
    public void setCantidadObjeto(int cantidad, String nombre) {
        for (Objetos objeto : objetos) {
            if (objeto.getNombre().equals(nombre)) {
                objeto.setCantidad(cantidad + objeto.getCantidad());
                break;
            }
        }
    }
    
    public boolean comprarHabilidad(String nombreHabilidad, int costo, Arbol arbolGeneral) {
    if (experiencia >= costo && todosPadresComprados(nombreHabilidad, arbolGeneral)) {
        NodoArbol nodo = arbolGeneral.buscarNodoPorNombre(nombreHabilidad);
        if (nodo != null) {
            habilidadesAdquiridas.insertarNodo(nodo.datos, nodo.getNombre(), nodo.getEfecto(), nodo.getCosto(),(float) nodo.getEstadistica());
            experiencia -= costo;
            aplicarEfectoHabilidad(nodo);
            return true;
        }
    }
    return false;
    }
    
    private void aplicarEfectoHabilidad(NodoArbol nodo) {
    String nombreHabilidad = nodo.getNombre();
    float estadistica = (float) nodo.getEstadistica();

    switch (nombreHabilidad) {
        case "Pies ligeros":
            velocidad += estadistica;
        case "Hiperativo":
            velocidad += estadistica;
            break;
        case "Hambre?":
            hambre -= estadistica;
        case "Esperanza es lo último que se pierde":
            hambre -= estadistica;
            break;
        case "Cansancio?":
            cansancio -= estadistica;
        case "Iron man":
            cansancio -= estadistica;
            break;
        default:
            System.out.println("Habilidad no reconocida: " + nombreHabilidad);
            break;
    }
}
    
    public boolean todosPadresComprados(String nombreHabilidad, Arbol arbolGeneral) {
    NodoArbol nodo = arbolGeneral.buscarNodoPorNombre(nombreHabilidad);
    while (nodo != null) {
        NodoArbol nodoPadre = nodo.getPadre();
        if (nodoPadre != null && buscarNodoPorNombre(nodoPadre.getNombre()) == null) {
            return false;
        }
        nodo = nodoPadre;
    }
    return true;
}
    

    private NodoArbol buscarNodoPorNombre(String nombre) {
        return habilidadesAdquiridas.buscarNodoPorNombre(nombre);
    }

    public Arbol getHabilidadesAdquiridas() {
        return habilidadesAdquiridas;
    }

    public ArrayList<Objetos> getObjetos() {
        return objetos;
    }
}
