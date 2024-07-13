/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura.semestral.estructuras.grafo;
import java.util.*;


import java.util.LinkedList;

public class Grafo {
    private int V;
    private LinkedList<Arista>[] adj;


    public Grafo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }


    public void agregarArista(int v, int w, int peso) {
        adj[v].add(new Arista(w, peso));
    }

    public void imprimirGrafo() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Lista de adyacencia del nodo " + i);
            for (Arista arista : adj[i]) {
                System.out.println(" -> " + arista.destino + " (peso: " + arista.peso + ")");
            }
            System.out.println();
        }
    }
    

    public void mostrarOpciones(int nodo) {
        System.out.println("Desde el nodo " + nodo + ", puedes moverte a:");
        for (Arista arista : adj[nodo]) {
            System.out.println(" -> Nodo " + arista.destino);
        }
    }


    public boolean esOpcionValida(int nodo, int opcion) {
        for (Arista arista : adj[nodo]) {
            if (arista.destino == opcion) {
                return true;
            }
        }
        return false;
    }
    
    public int getPeso(int nodoActual, int nodoDestino)
    {
        for (Arista arista : adj[nodoActual]) {
            if (arista.destino == nodoDestino) {
                return arista.peso;
            }
        }
        throw new IndexOutOfBoundsException("No se encontró el nodo destino en la lista de adyacencia del nodo actual.");
    }
    
    public void dijkstra(int origen, int destino) {
        int[] distancias = new int[V];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origen] = 0;

        boolean[] visitado = new boolean[V];
        int[] predecesor = new int[V];
        Arrays.fill(predecesor, -1);

        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.peso));
        pq.add(new Nodo(origen, 0));

        while (!pq.isEmpty()) {
            Nodo nodoActual = pq.poll();
            int nodo = nodoActual.nodo;

            if (visitado[nodo]) continue;
            visitado[nodo] = true;

            for (Arista arista : adj[nodo]) {
                int vecino = arista.destino;
                int pesoArista = arista.peso;

                if (!visitado[vecino] && distancias[nodo] + pesoArista < distancias[vecino]) {
                    distancias[vecino] = distancias[nodo] + pesoArista;
                 predecesor[vecino] = nodo;
                    pq.add(new Nodo(vecino, distancias[vecino]));
                }
            }
        }

    // Reconstruir el camino
    if (predecesor[destino] == -1) {
        System.out.println("No se encontró un camino desde " + origen + " hasta " + destino);
        return;
    }

    StringBuilder camino = new StringBuilder();
    for (int v = destino; v != origen; v = predecesor[v]) {
        camino.insert(0, " -> " + v); // Agregar el nodo al principio
    }
    camino.insert(0, origen); // Agregar el nodo de origen

    // Imprimir el camino
    System.out.println("El camino más corto desde " + origen + " hasta " + destino + " es: " + camino.toString());
}
    
    
    
    
    
    
    
    
    
    
    
    
    private static class Nodo {
        int nodo;
        int peso;

        Nodo(int nodo, int peso) {
            this.nodo = nodo;
            this.peso = peso;
        }
    }
}
