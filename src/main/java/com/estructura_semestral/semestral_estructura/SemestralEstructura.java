/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.estructura_semestral.semestral_estructura;


import com.estructura_semestral.frames.ArbolHabilidades;
import com.estructura.semestral.estructuras.grafo.Grafo;
import com.estructura.semestral.estructuras.arbol.Arbol;
import com.estructura.semestral.estructuras.arbol.NodoArbol;
import com.estructura.semestral.estructuras.maxheap.MaxHeap;
import java.util.Scanner;
import javax.swing.JDialog;
import java.io.*;

/**
 *
 * @author abrah
 */
public class SemestralEstructura {

    public static void main(String[] args) {
        JDialog jdialog = new JDialog();
        RellenarDatos rd = new RellenarDatos();
        Arbol arbol = new Arbol();
        arbol = rd.Habilidades(arbol);
        Jugador jugador = null;
        jugador = rd.rellenarJugador(jugador);
        Grafo g = new Grafo(10);
        rd.FormarLaberinto(g);
        int limite = 700000;
        float tiempoActual = 0;
        int distanciaTotal = 0;
        MaxHeap maxHeap = llenarMaxHeap(jugador);
        jugador.setObjetos(1, "comida", "Te quita en 10 el hambre");
        jugador.setObjetos(1, "pastillas", "Te recupera en 5 puntos la pierna y en 5 puntos la salud");
        jugador.setObjetos(1, "tranquilizante", "Te recuperar en 10 puntos la cordura");
        
        Scanner scanner = new Scanner(System.in);
        int nodoActual = 0;
        int nodoSalida = 9;
        boolean terminado = false;
        

        while (!terminado) {
            System.out.println("¿Que quiere hacer?");
            System.out.println("1. Moverse \n2. Ver Arbol de Habilidades \n3. Puedes buscar en la sala \n4. Dormir \n5. Ver estado \n6. Utilizar algun objeto\n7. Ver habilidades\n8. Comprar habilidades");
            int decision = scanner.nextInt();
            scanner.nextLine();

            switch (decision) {
                case 1: 
                    if (nodoActual == nodoSalida) {
                        System.out.println("¡Has llegado a la salida! ¡Felicidades!");
                        terminado = true;
                    } else {
                        g.mostrarOpciones(nodoActual);
                        System.out.print("Escribe el número del nodo al que quieres moverte (o -1 para salir): ");
                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        if (opcion == -1) {
                            System.out.println("Juego terminado.");
                            terminado = true;
                        } else if (g.esOpcionValida(nodoActual, opcion)) {
                            int distancia = g.getPeso(nodoActual, opcion);
                            distanciaTotal += distancia;
                            nodoActual = opcion;
                            System.out.println("Te has movido al nodo " + nodoActual);
                            tiempoActual += sacarDistancia(jugador.getVelocidad(), distancia);
                            if (tiempoActual >= limite) {
                                System.out.println("Se ha acabado el tiempo");
                                terminado = true;
                            }
                            jugador.setExperiencia(distancia);
                            jugador.setCansancio(distancia * 75);
                            jugador.setHambre(distancia * 0.02);
                            jugador.setCordura(distancia / 200);
                            double evento = Math.random() * 100;
                            if (evento < (1 + (distancia / 50))) {
                                System.out.println("Te golpeaste la pierna, 20 de salud en las piernas menos");
                                jugador.setPiernas(20);
                            } else if (evento > (1 + distancia / 50) && evento < (5 + distancia / 50)) {
                                System.out.println("Te doblaste el tobillo, 10 de salud en las piernas menos");
                                jugador.setPiernas(10);
                            }

                            if (jugador.getPiernas() > 90) {
                                System.out.println("Ya no te puede mover, por tu salud de piernas, haz perdido");
                                terminado = true;
                            }

                            if (jugador.getHambre() > 50)
                                jugador.setSalud(10);
                            if (jugador.getCansancio() > 75)
                                jugador.setSalud(5);

                            if (jugador.getSalud() > 80) {
                                System.out.println("Tienes poca salud, mueres");
                                terminado = true;
                            }

                            if (jugador.getCordura() > 80) {
                                System.out.println("Te volviste loco entre tanta oscuridad");
                                terminado = true;
                            }

                        } else {
                            System.out.println("Movimiento no válido. Intenta de nuevo.");
                        }
                    }
                    break;
                case 2:
                    ArbolHabilidades ah = new ArbolHabilidades(new javax.swing.JDialog(), true, arbol);
                    ah.setVisible(true);
                    break;
                case 3:
                    double probabilidad = Math.random() * 100;
                    if (probabilidad < 25) {
                        System.out.println("Haz encontrado comida");
                        jugador.setCantidadObjeto(1, "comida");
                    } else if (probabilidad < 1) {
                        g.dijkstra(nodoActual, 9);
                    } else if (probabilidad < 50) {
                        System.out.println("Haz encontrado medicina para la salud");
                        jugador.setCantidadObjeto(1, "pastillas");
                    } else if (probabilidad < 75) {
                        System.out.println("Haz encontrado tranquilizante");
                        jugador.setCantidadObjeto(1, "tranquilizante");
                    } else {
                        System.out.println("No haz encontrado nada");
                        jugador.setCansancio(5);
                    }
                    break;
                case 4:
                    System.out.println("Haz dormido exitosamente");
                    jugador.setCansancio(-20);
                    tiempoActual += 600;
                    break;
                case 5:
                    maxHeap = actualizar(jugador, maxHeap);
                    System.out.println("Tu estado:");
                    maxHeap.imprimirHeap();
                    break;
                case 6:
                    System.out.println("¿Qué objeto deseas utilizar?\n1. Comida\n2. Pastillas\n3. Tranquilizante");
                    int objetoUtilizar = scanner.nextInt();
                    scanner.nextLine(); 
                    switch (objetoUtilizar) {
                        case 1:
                            System.out.println("Comes un poco");
                            jugador.setCantidadObjeto(-1, "comida");
                            jugador.setHambre(-10);
                            break;
                        case 2:
                            System.out.println("Te curas un poco");
                            jugador.setCantidadObjeto(-1, "pastillas");
                            jugador.setSalud(-10);
                            break;
                        case 3:
                            System.out.println("Te tranquilizas un poco");
                            jugador.setCantidadObjeto(-1, "tranquilizante");
                            jugador.setCordura(-10);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
                case 7:
                    
                    break;
                case 8:
                    System.out.println("¿Qué habilidad deseas comprar? (Escribe el nombre)");
                    String nombreHabilidad = scanner.nextLine();
                    NodoArbol nodoHabilidad = arbol.buscarNodoPorNombre(nombreHabilidad);

                    if (nodoHabilidad != null && jugador.todosPadresComprados(nombreHabilidad, arbol)) {
                        int costo = nodoHabilidad.getCosto();
                        if (jugador.comprarHabilidad(nombreHabilidad, costo, arbol)) {
                            System.out.println("Habilidad comprada con éxito: " + nombreHabilidad);
                        } else {
                            System.out.println("No tienes suficiente experiencia para comprar esta habilidad.");
                        }
                    } else {
                        System.out.println("No has desbloqueado la habilidad padre o la habilidad no existe.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        scanner.close();
    }
    
    
    
    private static void disableConsoleInput() {
        
        InputStream nullInputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return -1; 
            }
        };

        System.setIn(nullInputStream);
    }
    
    public static double sacarDistancia(double velocidad, int distancia){
        return distancia/velocidad;
    }
    
    public static MaxHeap llenarMaxHeap(Jugador jugador)
    {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insertar((int) jugador.getCordura(), "Cordura", "Trata de tenerla al máximo posible, al llegar muy abajo se termina el juego");
        maxHeap.insertar((int) jugador.getPiernas(), "Piernas", "Tu daño a las piernas, mientras más tengas, iras más lento");
        maxHeap.insertar((int) jugador.getSalud(), "Salud", "Salud Actual, intenta tenerla lo más baja posible");
        maxHeap.insertar((int) jugador.getHambre(), "Hambre", "Si tienes mucha hambre...Mueres");
        return maxHeap;
    }
    
    public static MaxHeap actualizar(Jugador jugador, MaxHeap maxHeap)
    {
        maxHeap.actualizarNivel("Cordura", jugador.getCordura());
        maxHeap.actualizarNivel("Piernas", jugador.getPiernas());
        maxHeap.actualizarNivel("Salud", jugador.getSalud());
        maxHeap.actualizarNivel("Hambre", (int) jugador.getHambre());
        return maxHeap;
    }
    
    
}
