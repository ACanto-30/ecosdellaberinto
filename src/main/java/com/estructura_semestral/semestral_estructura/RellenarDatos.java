/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura_semestral.semestral_estructura;

import com.estructura.semestral.estructuras.grafo.Grafo;
import com.estructura.semestral.estructuras.arbol.Arbol;
import java.util.ArrayList;


public class RellenarDatos {
    
    public void FormarLaberinto(Grafo g)
    {
  
        g.agregarArista(0, 1, 200);
        g.agregarArista(0, 2, 400);
        g.agregarArista(1, 3, 100);
        g.agregarArista(1, 4, 700);
        g.agregarArista(2, 5, 300);
        g.agregarArista(2, 6, 200);
        g.agregarArista(3, 7, 600);
        g.agregarArista(4, 8, 500);
        g.agregarArista(5, 9, 200); // Camino "difícil" o "costoso" a la salida
        g.agregarArista(6, 7, 800);
        g.agregarArista(7, 8, 100);
        g.agregarArista(8, 9, 1000);

        // Aristas bidireccionales (si es necesario)
        g.agregarArista(1, 0, 200);
        g.agregarArista(2, 0, 400);
        g.agregarArista(3, 1, 100);
        g.agregarArista(4, 1, 700);
        g.agregarArista(5, 2, 300);
        g.agregarArista(6, 2, 200);
        g.agregarArista(7, 3, 600);
        g.agregarArista(8, 4, 500);
        g.agregarArista(9, 5, 200);
        g.agregarArista(7, 6, 800);
        g.agregarArista(8, 7, 100);
        g.agregarArista(9, 8, 10000);
        
        
    }
    
    public Jugador rellenarJugador(Jugador jugador)
    {
        ArrayList<Objetos> listaObjetos = new ArrayList<>();
        listaObjetos.add(new Objetos(1, "comida", "Te quita en 10 el hambre"));
        listaObjetos.add(new Objetos(1, "pastillas", "Te recupera en 5 puntos la pierna y en 5 puntos la salud"));
        listaObjetos.add(new Objetos(1, "tranquilizante", "Te recupera en 10 puntos la cordura"));
        jugador = new Jugador(8.2, 12, 21, 22, 13, 12, listaObjetos);
        return jugador;
    }
    
    public Arbol Habilidades(Arbol arbol)
    {
        arbol.insertarNodo(1, "Una habilidad?", "Sientes algo raro en mis las manos", 500, 0);

        
        arbol.insertarEnNodo(1, 2, "Pies ligeros", "Corres 1mts más rápido",  750, 1);
        arbol.insertarEnNodo(1, 3, "Hambre?", "Cada caminata recuperas 5 de puntos en hambre",  750, 5);
        arbol.insertarEnNodo(1, 4, "Cansancio?", "Te haz acostumbrado a las largas caminatas, después de cada caminata sientes menos cansancio",  750, 10);

      
        arbol.insertarEnNodo(2, 5, "Hiperativo", "Corres 2mts más rápido", 1000, 2);
        arbol.insertarEnNodo(3, 6, "Esperanza es lo último que se pierde", "Multiplica el anterior efecto", 1000, 10);
        arbol.insertarEnNodo(4, 7, "Iron man", "Ya casi no sientes cansancio", 1000, 20);
        return arbol;
    }
}
