/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO1;

/**
 *
 * @author fer
 */
public class Caballo {
    
    String nombre;
    int posicion; 
    boolean jugador;
    
    
    //constructor
    public Caballo(String nombre, boolean jugaddor){
        
        this.jugador = jugador; // define si es jugador o bot 
        this.nombre = nombre;
        this.posicion = 0; //inicia posicion en 0
        
    }
    
    //metodos que obtienen nombre, posicion, para avanzar y que verifican si es jugador o bot
    
    public String getNombre(){
        return nombre;
    }
    public int getPosicion(){
        return posicion;
    }
    
    public void avanzar(int avance){
        posicion+= avance;
    }
    public boolean getJugador(){
        return jugador;
    }
    
//    
    
    
}
