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
public class Juego3 {
            
    public void BattleShip(){
      Scanner scanner = new Scanner(System.in);

     
       System.out.println("Bienvenido a Batalla Naval!");
        System.out.println("Ingrese su nombre:");
        String nombreJugador = scanner.nextLine();
        System.out.println("Ingrese el número de filas del tablero (máximo 26):");
        int filas = scanner.nextInt();
        System.out.println("Ingrese el número de columnas del tablero (máximo 26):");
        int columnas = scanner.nextInt();

        // Validación del tamaño del tablero, se ajusta a 10x10 si se supera el límite.
        if (filas > 26 || columnas > 26) {
            System.out.println("El tamaño máximo permitido es de 26x26. Configurando a 10x10 por defecto.");
            filas = 10;
            columnas = 10;
        }

        // Creación del primer jugador.
        Jugador jugador1 = new Jugador1(nombreJugador, filas, columnas);

        // Selección del oponente: puede ser otro jugador o la computadora.
        System.out.println("Seleccione el modo de juego: \n1. Contra otro jugador\n2. Contra la computadora");
        int modo = scanner.nextInt();
        Jugador jugador2;

        if (modo == 1) {
            // Si el jugador elige jugar contra otro jugador, se solicita el nombre del segundo jugador.
            System.out.println("Ingrese el nombre del segundo jugador:");
            scanner.nextLine(); // Para consumir el salto de línea pendiente.
            String nombreJugador2 = scanner.nextLine();
            jugador2 = new Jugador1(nombreJugador2, filas, columnas); // Se crea el segundo jugador.
        } else {
            // Si el jugador elige jugar contra la computadora, se crea una instancia de la clase Computadora.
            jugador2 = new Computadora("Computadora", filas, columnas);
        }

        // Ambos jugadores colocan sus barcos en el tablero.
        jugador1.colocarBarcos();
        jugador2.colocarBarcos();

       boolean juegoTerminado = false;
while (!juegoTerminado) {
    // Turno del jugador 1.
    jugador1.atacar(jugador2);
    // Si el jugador 2 ha perdido todos sus barcos, el jugador 1 gana.
    if (jugador2.tableroJugador.barcosHundidos()) {
        System.out.println(jugador1.nombreJugador + " ha ganado la partida!");
        juegoTerminado = true;
    } else {
        // Turno del jugador 2 (ya sea otro jugador humano o la computadora).
        jugador2.atacar(jugador1);
        // Si el jugador 1 ha perdido todos sus barcos, el jugador 2 gana.
        if (jugador1.tableroJugador.barcosHundidos()) {
            System.out.println(jugador2.nombreJugador + " ha ganado la partida!");
            juegoTerminado = true;
        }
    }
    }
 
        
        }//fin metodo
        }//fin clase

      
        
   
    

