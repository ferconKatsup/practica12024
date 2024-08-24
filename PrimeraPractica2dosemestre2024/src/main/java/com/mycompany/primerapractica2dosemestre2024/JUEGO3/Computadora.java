/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO3;

import java.util.Random;

/**
 *
 * @author fer
 */
class Computadora extends Jugador {

    private Random random = new Random();

     public Computadora(String nombre, int filas, int columnas) {
        super(nombre, filas, columnas);
    }


    @Override
    public void colocarBarcos() {
        System.out.println( "coloco sus barcos");
        Barco[] barcos = {new PortaAviones(), new Acorazado(), new Crucero(), new Submarino(), new Destructor()};

        for (Barco barco : barcos) {
            boolean colocado = false;
            while (!colocado) {
                
                //posiciones aleatorias
                int filaInicio = random.nextInt(tableroJugador.getFilas());
                int columnaInicio = random.nextInt(tableroJugador.getColumnas());
                int filaFinal = filaInicio;
                int columnaFinal = columnaInicio;
                
                
                //colcocacion aleatoria en h o v 
                if (random.nextBoolean()) {
                    columnaFinal += barco.tamaño - 1;
                } else {
                    filaFinal += barco.tamaño - 1;
                }
                
                if (barco.colocarBarco(filaInicio, columnaInicio, filaFinal, columnaFinal,tableroJugador)) {
                  
                    colocado = true;
                }

            }
        }
    }//fin metodo colocarB

  /*  public boolean colocacionValida(int filaInicio, int columnaInicio, int filaFinal, int columnaFinal, Tablero tableroJugador1) {
        if (filaFinal >= 10 || columnaFinal >= 10) {
            return false;
        }
        if (filaInicio > filaFinal || columnaInicio > columnaFinal) {
            return false;
        }
        for (int i = filaInicio; i <= filaFinal; i++) {
            for (int j = columnaInicio; j <= columnaFinal; j++) {
                if (tableroJugador.atacar(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }*/

    public void atacar(Jugador jugador2) {
      boolean atacado = false;
        while (!atacado) {
            // Genera coordenadas aleatorias para el ataque.
            int fila = random.nextInt(tableroEnemigo.getFilas());
            int columna = random.nextInt(tableroEnemigo.getColumnas());

            // Si acierta un barco, se marca en el tablero enemigo.
            if (jugador2.tableroJugador.atacar(fila, columna)) {
                System.out.println("¡Computadora tocó un barco en " + (char) ('A' + fila) + (columna + 1) + "!");
                tableroEnemigo.colocar(fila, columna, fila, columna, 'X');
                atacado = true;
            } else {
                System.out.println("¡Agua en " + (char) ('A' + fila) + (columna + 1) + "!");
                tableroEnemigo.colocar(fila, columna, fila, columna, 'O');
                atacado = true;
            }
        }
        tableroEnemigo.mostrarTablero(); // Muestra el tablero enemigo actualizado.
    
        
        
            
        }
}//fin clase IA
