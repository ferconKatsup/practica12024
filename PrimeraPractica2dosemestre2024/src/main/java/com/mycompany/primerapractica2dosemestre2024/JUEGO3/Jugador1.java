/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO3;

import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Jugador1 extends Jugador {

    private Scanner scanner = new Scanner(System.in);

    public Jugador1(String nombre, int filas, int columnas) {
        super(nombre, filas, columnas);
    }

    public void colocarBarcos() {
        System.out.println(nombreJugador + "Coloca tus barcos");
        tableroJugador.mostrarTablero();

        Barco[] barcos = {new PortaAviones(), new Acorazado(), new Crucero(), new Submarino(), new Destructor()};
//ciclo que le solicita al jugador colocar los barcos 
        for (Barco barco : barcos) {
            boolean colocado = false;
            while (!colocado) {
                System.out.println("coloca" + barco.nombre + " [ " + barco.tamaño + "celdas ]");
                System.out.println("ingresa fila inicial(A-" + (char) ('A' + tableroJugador.getFilas() - 1));
                char filaInicio = scanner.next().charAt(0);

                System.out.println("ingresa columna inicial (1-" + tableroJugador.getColumnas());
                int columnaInicio = scanner.nextInt();

                System.out.println("ingresa fila final((A-" + (char) ('A' + tableroJugador.getFilas() - 1));
                char filaFinal = scanner.next().charAt(0);

                System.out.println("ingresa columna final (1-)" + tableroJugador.getColumnas());
                int columnaFinal = scanner.nextInt();

                // colocar barco 
             
                if (barco.colocarBarco(filaInicio - 'A', columnaInicio - 1, filaFinal - 'A', columnaFinal - 1, tableroJugador)) {
                    tableroJugador.mostrarTablero();
                    colocado = true; // Marca que el barco fue colocado correctamente.
                } else {
                    // Si la posición es inválida, se solicita al jugador que intente de nuevo.
                    System.out.println("Posición inválida o fuera de límites. Intenta nuevamente.");
                }
            }

        }
    }

    public void atacar(Jugador jugador2) {
        System.out.println(nombreJugador + ", ingresa coordenadas para atacar:");
        System.out.println("Fila (A-" + (char)('A' + tableroEnemigo.getFilas() - 1) + "):");
        char fila = scanner.next().charAt(0);

        System.out.println("Columna (1-" + tableroEnemigo.getColumnas() + "):");
        int columna = scanner.nextInt();

        if (jugador2.tableroJugador.atacar(fila - 'A', columna - 1)) {
            System.out.println(" atacado");
            tableroEnemigo.colocar(fila - 'A', columna - 1, fila - 'A', columna - 1, 'x');
        } else {
            System.out.println("era agua, no pasa nada");
            tableroEnemigo.colocar(fila - 'A', columna - 1, fila - 'A', columna - 1, 'O');
        }
        System.out.println("Tablero enemigo ");
        tableroEnemigo.mostrarTablero(); //muestra ataques realizados(si dios quiree )
    }

}
