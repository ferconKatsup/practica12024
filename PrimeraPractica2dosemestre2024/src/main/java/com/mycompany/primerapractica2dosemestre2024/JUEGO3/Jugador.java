/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO3;

/**
 *
 * @author fer
 */
abstract class Jugador {
    
    protected String nombreJugador;
    protected Tablero tableroJugador; 
    protected Tablero tableroEnemigo;
    
    
    public Jugador (String nombre, int filas, int columnas){

        this.nombreJugador = nombre;
                
        this.tableroJugador = new Tablero(filas, columnas);
        this.tableroEnemigo = new Tablero(filas, columnas);
        
        
    }//fin constructor jugador
    
    public abstract void colocarBarcos();
    public abstract void atacar(Jugador jugador2);
}
