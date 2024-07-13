package com.estructura.semestral.estructuras.maxheap;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap {
    private ArrayList<NodoMaxHeap> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insertar(int nivel, String nombre, String efecto) {
        NodoMaxHeap nuevoNodo = new NodoMaxHeap(nivel, nombre, efecto);
        heap.add(nuevoNodo);
        burbujearHaciaArriba(heap.size() - 1);
    }

    private void burbujearHaciaArriba(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;
            if (heap.get(indice).nivel > heap.get(padre).nivel) {
                Collections.swap(heap, indice, padre);
                indice = padre;
            } else {
                break;
            }
        }
    }

    
    public NodoMaxHeap extraerMaximo() {
        if (heap.isEmpty()) return null;

        NodoMaxHeap max = heap.get(0);
        NodoMaxHeap ultimoNodo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimoNodo);
            burbujearHaciaAbajo(0);
        }

        return max;
    }

    
    private void burbujearHaciaAbajo(int indice) {
        int tamano = heap.size();
        int mayor = indice;

        while (true) {
            int izquierda = 2 * indice + 1;
            int derecha = 2 * indice + 2;

            if (izquierda < tamano && heap.get(izquierda).nivel > heap.get(mayor).nivel) {
                mayor = izquierda;
            }

            if (derecha < tamano && heap.get(derecha).nivel > heap.get(mayor).nivel) {
                mayor = derecha;
            }

            if (mayor != indice) {
                Collections.swap(heap, indice, mayor);
                indice = mayor;
            } else {
                break;
            }
        }
    }


    public void imprimirHeap() {
        ArrayList<NodoMaxHeap> nodosOrdenados = new ArrayList<>(heap);
        Collections.sort(nodosOrdenados, (n1, n2) -> Integer.compare(n2.nivel, n1.nivel)); 
        for (NodoMaxHeap nodo : nodosOrdenados) {
            nodo.imprimir();
        }
    }
    
    public void actualizarNivel(String nombre, int nuevoNivel) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).nombre.equals(nombre)) {
                int nivelAntiguo = heap.get(i).nivel;
                heap.get(i).nivel = nuevoNivel;

                // Reacomodar
                if (nuevoNivel > nivelAntiguo) {
                    burbujearHaciaArriba(i);
                } else {
                    burbujearHaciaAbajo(i);
                }
                return;
            }
        }
        System.out.println("No se encontró un nodo con el nombre: " + nombre);
    }
}